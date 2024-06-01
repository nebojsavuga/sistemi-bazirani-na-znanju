import { Component, Input, OnInit } from '@angular/core';
import { ArticleRatingDTO } from '../../shared/models/articles';

@Component({
  selector: 'app-rating-display',
  templateUrl: './rating-display.component.html',
  styleUrl: './rating-display.component.css'
})
export class RatingDisplayComponent implements OnInit{

  _ratings: ArticleRatingDTO[] = [];
  averageRating: number = 0;

  get ratings(){
    return this._ratings;
  }

  @Input() set ratings(value: ArticleRatingDTO[]){
    this._ratings = value;
    if(this.ratings.length > 0){
      const ratingValues: number[] = this.ratings.map(x => x.rating);
      let total = 0;
      ratingValues.forEach(element => {
        total += element;
      });
      this.averageRating = total / ratingValues.length;
      const roundedRating = Math.round(this.averageRating);
      this.updateStarRatings(roundedRating);
    }
  }

  ngOnInit(): void {
    
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
