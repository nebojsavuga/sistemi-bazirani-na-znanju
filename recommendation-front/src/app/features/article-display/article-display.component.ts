import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleRatingDTO, FullArticle, RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';
import { RecomendationService } from '../../core/services/recomendation.service';
import { SnackbarService } from '../../core/services/snackbar.service';
import { UserService } from '../../core/services/user.service';
import { CodeDTO } from '../../shared/models/code';

@Component({
  selector: 'app-article-display',
  templateUrl: './article-display.component.html',
  styleUrl: './article-display.component.css'
})
export class ArticleDisplayComponent implements OnInit {

  id: number;
  article: FullArticle = null;
  ratings: ArticleRatingDTO[] = [];
  backwardTypes: string[] = []
  similarArticles: RecommendedArticle[] = [];
  totalSimilarArticles: RecommendedArticle[] = [];
  sliceIndex = 0;
  disableShowMore = false;
  isLoggedIn = false;
  codes: CodeDTO[] = [];
  selectedCodeId: number = 0;
  oldPrice = '';

  constructor(private articleService: ArticleService,
    private authService: AuthenticationService,
    private recomendationService: RecomendationService,
    private userService: UserService,
    private route: ActivatedRoute,
    private snackbar: SnackbarService,
    private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.authService.userStateLoggedIn$.subscribe(
      res => {
        this.isLoggedIn = res;
      }
    );
    this.getAllItems(this.id);

  }

  private getAllItems(id: number) {
    this.selectedCodeId = 0;
    this.articleService.getById(id).subscribe(
      res => {
        this.article = res;
        this.authService.getPicture('images/' + this.article.imagePath).subscribe(result => {
          const url = URL.createObjectURL(result);
          (document.getElementById(this.article.id.toString()) as HTMLImageElement).src = url;
          this.oldPrice = this.article.price;
        });
        this.getCodes();
      }
    );
    this.recomendationService.getParents(id).subscribe(
      res => {
        this.backwardTypes = res.reverse();
        if(this.backwardTypes[1] === 'Article'){
          const back = this.backwardTypes[1];
          this.backwardTypes[1] = this.backwardTypes[0];
          this.backwardTypes[0] = back;
        }
      }
    );
    this.recomendationService.getSimilar(id).subscribe(
      res => {
        this.similarArticles = res;
        this.totalSimilarArticles = this.similarArticles.slice(0, 4 * (this.sliceIndex + 1));
      }
    );
    this.articleService.getRatings(id).subscribe(
      res => {
        this.ratings = res;
      }
    );

  }

  private getCodes() {
    this.userService.getCodes().subscribe(
      res => {

        this.codes = [];
        for (const code of res) {
          switch (code.flag) {
            case 0:
              const articleType = this.articleService.getTypeOfArticle(this.article);
              if (articleType.toLocaleLowerCase().includes(code.sport.toLocaleLowerCase())) {
                this.codes.push(code);
              }
              break;
            default:
              this.codes.push(code);
              break;
          }
        }
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
    this.id = id;
    this.getAllItems(id);
    this.disableShowMore = false;

  }

  buy() {
    this.articleService.buy(this.article.id, this.selectedCodeId).subscribe(
      {
        next: (res) => {
          const price = parseFloat(Number.parseFloat(res.price).toFixed(2));
          this.snackbar.showSnackBar(`Uspešno ste kupili artiklal ${this.article.name} sa cenom ${price} eur`, 'Ok');
          this.selectedCodeId = 0;
          this.getCodes();
          this.article.price = this.oldPrice;
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
          if (response.status === 200) {
            this.snackbar.showSnackBar(`Uspešno ste dodali ${this.article.name} u listu omiljenih artikala`, 'Ok');
            return;
          }
          this.snackbar.showSnackBar(`Došlo je do greške prilikom dodavanja artikla ${this.article.name} u listu omiljenih.`, 'Ok');
        }
      }
    );
  }

  onCodeChange(event: Event): void {
    const selectElement = event.target as HTMLSelectElement;
    this.selectedCodeId = Number(selectElement.value);
    if(this.selectedCodeId === 0){
      this.article.price = this.oldPrice;
      return;
    }
    const code = this.codes.find(c => c.id === this.selectedCodeId);
    if(code.discountPrice > 0){
      this.article.price = String(Number.parseFloat(this.article.price) - code.discountPrice);
    }else{
      this.article.price = String(Number.parseFloat(this.article.price) - Number.parseFloat(this.article.price) * (code.discountPercentage / 100));
    }
    if(Number.parseFloat(this.article.price) < 0){
      this.article.price = '0';
      return;
    }
    this.article.price = String(Number.parseFloat(this.article.price).toFixed(2));

  }

  ratedArticle($event: any) {
    this.getAllItems(this.id);
  }
} 
