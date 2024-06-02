import { Component, ElementRef, EventEmitter, Input, OnInit, Output, Renderer2, ViewChild } from '@angular/core';
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
  @ViewChild('articleImage') articleImage: ElementRef<HTMLImageElement>;
  
  constructor(private router: Router, private authService: AuthenticationService,
    private articleService: ArticleService,
    private renderer: Renderer2
  ) { }
  @Output() articleId: EventEmitter<any> = new EventEmitter<number>();
  @Output() deleted: EventEmitter<any> = new EventEmitter<boolean>();
  @Output() edit: EventEmitter<any> = new EventEmitter<number>();

  ngOnInit(): void {
    this.authService.getPicture('images/' + this.article.pathToImage).subscribe(result => {
      const url = URL.createObjectURL(result);
      this.renderer.setAttribute(this.articleImage.nativeElement, 'src', url);
    });
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
