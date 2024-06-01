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

  constructor(private articleService: ArticleService,
    private userService: UserService,
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
        },
        error: err => {
          this.snackBarService.showSnackBar('Došlo je do greške prilikom učitavanja omiljenih artikala.', 'Ok');
        }
      }
    );
  }

  deleteArticle(event: any) {
    if (event) {
      this.snackBarService.showSnackBar('Uspešno ste obrisali artikal iz liste omiljenih.', 'Ok');
      this.getFavorites();
    }
  }

}
