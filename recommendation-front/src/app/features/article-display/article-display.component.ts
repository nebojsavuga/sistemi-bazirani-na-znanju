import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleRatingDTO, FullArticle, RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';
import { RecomendationService } from '../../core/services/recomendation.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-article-display',
  templateUrl: './article-display.component.html',
  styleUrl: './article-display.component.css'
})
export class ArticleDisplayComponent implements OnInit {

  id: number;
  article: FullArticle = null;
  backwardTypes: string[] = []
  similarArticles: RecommendedArticle[] = [];
  totalSimilarArticles: RecommendedArticle[] = [];
  sliceIndex = 0;
  disableShowMore = false;
  ratings: ArticleRatingDTO[] = [];
  constructor(private articleService: ArticleService,
    private authService: AuthenticationService,
    private recomendationService: RecomendationService,
    private route: ActivatedRoute,
    private snackbar: SnackbarService,
    private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.getAllItems(this.id);
    this.articleService.getRatings(this.id).subscribe(
      res =>{
        this.ratings = res;
      }
    );
  }

  private getAllItems(id: number) {
    this.articleService.getById(id).subscribe(
      res => {
        this.article = res;
        this.authService.getPicture('images/' + this.article.imagePath).subscribe(result => {
          const url = URL.createObjectURL(result);
          (document.getElementById(this.article.id.toString()) as HTMLImageElement).src = url;
        });
      }
    );
    this.recomendationService.getParents(id).subscribe(
      res => {
        this.backwardTypes = res.reverse();
      }
    );
    this.recomendationService.getSimilar(id).subscribe(
      res => {
        this.similarArticles = res;
        this.totalSimilarArticles = this.similarArticles.slice(0, 4 * (this.sliceIndex + 1));
      }
    );
  }

  showMore() {
    this.sliceIndex += 1;
    this.disableShowMore = false;
    if (this.totalSimilarArticles.length >= this.similarArticles.length - 4) {
      this.disableShowMore = true;
    }
    this.totalSimilarArticles = this.similarArticles.slice(0, 4 * (this.sliceIndex + 1));
  }

  onBackwardClick(value: string) {
    this.router.navigate([value, 'articles']);
  }

  changeArticle(id: number) {
    this.sliceIndex = 0;
    setTimeout(() => {
      window.scrollTo({ top: 10, behavior: 'smooth' });
    }, 0);
    this.getAllItems(id);
    this.disableShowMore = false;

  }

  buy() {
    this.articleService.buy(this.article.id).subscribe(
      {
        next: _ => {
          this.snackbar.showSnackBar(`Uspešno ste kupili artiklal ${this.article.name}`, 'Ok');
        },
        error: _ => {
          this.snackbar.showSnackBar(`Došlo je do greške prilikom kupovine artikla ${this.article.name}`, 'Ok');
        }
      }
    );
  }

  addToFavorite() {
    this.articleService.addToFavorite(this.article.id).subscribe(
      {
        next: res => {
          this.snackbar.showSnackBar(`Uspešno ste dodali ${this.article.name} u listu omiljenih artikala`, 'Ok');
        },
        error: response => {
          if(response.status === 200){
            this.snackbar.showSnackBar(`Uspešno ste dodali ${this.article.name} u listu omiljenih artikala`, 'Ok');
            return;
          }
          this.snackbar.showSnackBar(`Došlo je do greške prilikom dodavanja artikla ${this.article.name} u listu omiljenih.`, 'Ok');
        }
      }
    );
  }

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

} 
