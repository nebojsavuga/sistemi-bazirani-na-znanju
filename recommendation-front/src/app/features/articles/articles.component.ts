import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {
  @Input() articles: RecommendedArticle[] = [];
  @Input() isFavorite: boolean | undefined = false;
  @Output() deleted: EventEmitter<any> = new EventEmitter<boolean>();

  deleteArticle(event: boolean){
    this.deleted.emit(event);
  }
}
