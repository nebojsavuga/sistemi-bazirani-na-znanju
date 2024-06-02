import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { RecommendedArticle, SportSales, TopRatedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.css'
})
export class ReportsComponent implements OnInit {

  topRated: TopRatedArticle[] = [];
  articles: RecommendedArticle[] = [];
  sales: SportSales;

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getTopRated().subscribe(
      res => {
        this.topRated = res;
        this.topRated.sort((a, b) => b.rating - a.rating);
        this.articles = this.topRated.map((art: RecommendedArticle) => {
          return {
            id: art.id,
            name: art.name,
            brandName: art.brandName,
            price: art.price,
            pathToImage: art.pathToImage,
            articleType: art.articleType,
            rating: art.rating,
            totalRatings: art.totalRatings
          };
        });
      }
    );
    this.articleService.getSalesPerSport().subscribe(
      res => {
        this.sales = res;
      }
    );
  }

}
