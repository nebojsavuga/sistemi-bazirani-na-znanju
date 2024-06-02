import { Component, Input, OnInit } from '@angular/core';
import { ArticleRatingDTO } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-rating-display',
  templateUrl: './rating-display.component.html',
  styleUrl: './rating-display.component.css'
})
export class RatingDisplayComponent implements OnInit {

  _id: number;
  @Input() set id(value: number) {
    this._id = value;
    
  }

  get id() {
    return this._id;
  }
  _ratings: ArticleRatingDTO[] = [];

  @Input() set ratings(value: ArticleRatingDTO[]){
    this._ratings = value;
    this.setRatings();
  }
  averageRating: number = 0;

  constructor(private articleService: ArticleService) {

   }

  ngOnInit(): void {
    this.setRatings();
  }

  private setRatings() {
    this.averageRating = 0;
    const ratingValues: number[] = this._ratings.map(x => x.rating);
    let total = 0;
    ratingValues.forEach(element => {
      total += element;
    });
    if (ratingValues.length !== 0) {
      this.averageRating = total / ratingValues.length;
    }
    const roundedRating = Math.round(this.averageRating);
    this.updateStarRatings(roundedRating);
  }

  updateStarRatings(rating: number): void {
    for (let i = 1; i <= 5; i++) {
      const star = document.getElementById(`rating${i}`);
      if (star) {
        if (i <= rating) {
          star.classList.add('checked');
        } else {
          star.classList.remove('checked');
        }
      }
    }
  }
}
