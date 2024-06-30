import { Component, OnInit } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';
import { UserService } from '../../core/services/user.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-favorite-display',
  templateUrl: './favorite-display.component.html',
  styleUrl: './favorite-display.component.css'
})
export class FavoriteDisplayComponent implements OnInit {

  articles: RecommendedArticle[] = [];
  totalSimilarArticles: RecommendedArticle[] = [];
  sliceIndex = 0;
  disableShowMore = false;
  isLoggedIn = false;
  constructor(private articleService: ArticleService,
    private snackBarService: SnackbarService
  ) { }

  ngOnInit(): void {
    this.getFavorites();
  }

  private getFavorites() {
    this.articleService.getFavorites().subscribe(
      {
        next: res => {
          this.articles = res;
          this.totalSimilarArticles = this.articles.slice(0, 4 * (this.sliceIndex + 1));
        },
        error: err => {
          this.snackBarService.showSnackBar('There was a mistake while loading favorite articles.', 'Ok');
        }
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

  deleteArticle(event: any) {
    if (event) {
      this.snackBarService.showSnackBar('Successfully deleted article from favorites.', 'Ok');
      this.getFavorites();
    }
  }

}
