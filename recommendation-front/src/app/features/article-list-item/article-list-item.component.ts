import { Component, Input } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-article-list-item',
  templateUrl: './article-list-item.component.html',
  styleUrl: './article-list-item.component.css'
})
export class ArticleListItemComponent {
  @Input() article: RecommendedArticle;

}
