import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { RecomendationService } from '../../core/services/recomendation.service';
import { RecommendedArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-store-home',
  templateUrl: './store-home.component.html',
  styleUrl: './store-home.component.css'
})
export class StoreHomeComponent {

  constructor(private recomendationService: RecomendationService) { }
  articles: RecommendedArticle[] = [];
  handleFilterSubmit(event: any) {

    this.recomendationService.recommend(event).subscribe(
      res => {
        this.articles = res;
      }
    )
  }
}
