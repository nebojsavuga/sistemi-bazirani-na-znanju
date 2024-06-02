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
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getPurchases().subscribe(
      res => {
        this.articles = res;
      }
    );
  }
}
