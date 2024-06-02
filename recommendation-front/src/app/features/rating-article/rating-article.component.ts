import { Component, ElementRef, EventEmitter, Input, OnInit, Output, Renderer2, ViewChild } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-rating-article',
  templateUrl: './rating-article.component.html',
  styleUrl: './rating-article.component.css'
})
export class RatingArticleComponent implements OnInit {
  @Input() article: RecommendedArticle;
  @Input() rating: number = 0;
  @Input() totalRatings: number = 0;
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