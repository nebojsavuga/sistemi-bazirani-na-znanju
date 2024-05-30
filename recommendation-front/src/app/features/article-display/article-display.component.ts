import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ActivatedRoute } from '@angular/router';
import { FullArticle, RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';
import { RecomendationService } from '../../core/services/recomendation.service';

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

  constructor(private articleService: ArticleService,
    private authService: AuthenticationService,
    private recomendationService : RecomendationService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.getAllItems(this.id);
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
      }
    );
  }

  onBackwardClick(value){
    alert(value);
  }

  changeArticle(id: number){
    this.getAllItems(id);
  }

} 
