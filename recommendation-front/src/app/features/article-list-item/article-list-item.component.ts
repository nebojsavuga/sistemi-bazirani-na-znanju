import { Component, Input } from '@angular/core';
import { RecommendedArticle } from '../../shared/models/articles';
import { Router } from '@angular/router';

@Component({
  selector: 'app-article-list-item',
  templateUrl: './article-list-item.component.html',
  styleUrl: './article-list-item.component.css'
})
export class ArticleListItemComponent {
  @Input() article: RecommendedArticle;
  constructor(private router: Router) { }

  showArticle(id: number) {
    this.router.navigate([id + '/article']);
  }
}
