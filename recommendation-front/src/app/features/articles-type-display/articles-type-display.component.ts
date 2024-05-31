import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { ActivatedRoute } from '@angular/router';
import { RecommendedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-articles-type-display',
  templateUrl: './articles-type-display.component.html',
  styleUrl: './articles-type-display.component.css'
})
export class ArticlesTypeDisplayComponent implements OnInit {

  value: string = '';
  disableShowMore = false;
  constructor(private articleService: ArticleService, private route: ActivatedRoute) { }
  articles: RecommendedArticle[] = [];
  totalArticles: RecommendedArticle[] = [];
  sliceIndex = 0;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.value = params['type'];
    });
    this.articleService.getByType(this.value).subscribe(
      res => {
        this.articles = res;
        this.totalArticles = this.articles.slice(0, 8 * (this.sliceIndex + 1));
      }
    );
  }

  showMore() {
    this.sliceIndex += 1;
    this.disableShowMore = false;
    if (this.totalArticles.length >= this.articles.length - 8) {
      this.disableShowMore = true;
    }
    this.totalArticles = this.articles.slice(0, 8 * (this.sliceIndex + 1));
  }
}
