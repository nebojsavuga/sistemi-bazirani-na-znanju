import { Component, Input } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {
  @Input() articles: RecommendedArticle[] = [];
}
