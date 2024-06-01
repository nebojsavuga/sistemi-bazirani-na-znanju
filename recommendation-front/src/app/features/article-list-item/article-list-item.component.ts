import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-article-list-item',
  templateUrl: './article-list-item.component.html',
  styleUrl: './article-list-item.component.css'
})
export class ArticleListItemComponent implements OnInit {
  @Input() article: RecommendedArticle;
  @Input() isFavorite: boolean | undefined = false;
  @Input() isAdmin: boolean | undefined = false;
  constructor(private router: Router, private authService: AuthenticationService,
    private articleService: ArticleService
  ) { }
  @Output() articleId: EventEmitter<any> = new EventEmitter<number>();
  @Output() deleted: EventEmitter<any> = new EventEmitter<boolean>();

  ngOnInit(): void {
    this.authService.getPicture('images/' + this.article.pathToImage).subscribe(result => {
      const url = URL.createObjectURL(result);
      (document.getElementById(this.article.id.toString()) as HTMLImageElement).src = url;
    });
    console.log(this.isAdmin);
  }

  showArticle(id: number) {
    this.router.navigate([id + '/article']);
    this.articleId.emit(this.article.id);
  }

  removeFromFavorites() {
    this.articleService.deleteFavorite(this.article.id).subscribe(
      res => {
        this.deleted.emit(true);
      }
    )
  }
}
