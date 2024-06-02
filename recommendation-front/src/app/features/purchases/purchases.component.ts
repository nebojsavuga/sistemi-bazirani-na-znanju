import { Component, OnInit } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrl: './purchases.component.css'
})
export class PurchasesComponent implements OnInit {

  articles: RecommendedArticle[] = [];
  totalSimilarArticles: RecommendedArticle[] = [];
  sliceIndex = 0;
  disableShowMore = false;
  isLoggedIn = false;
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getPurchases().subscribe(
      res => {
        this.articles = res;
        this.totalSimilarArticles = this.articles.slice(0, 4 * (this.sliceIndex + 1));

      }
    );
  }

  showMore() {
    this.sliceIndex += 1;
    this.disableShowMore = false;
    if (this.totalSimilarArticles.length >= this.articles.length - 4) {
      this.disableShowMore = true;
    }
    this.totalSimilarArticles = this.articles.slice(0, 4 * (this.sliceIndex + 1));
  }
}
