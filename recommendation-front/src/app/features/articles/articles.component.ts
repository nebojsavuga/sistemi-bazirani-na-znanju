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
  @Input() isAdmin: boolean | undefined = false;
  @Output() deleted: EventEmitter<any> = new EventEmitter<boolean>();
  @Output() edit: EventEmitter<any> = new EventEmitter<number>();

  deleteArticle(event: boolean){
    this.deleted.emit(event);
  }
  editArticle(event: number){
    this.edit.emit(event);
  }
}
