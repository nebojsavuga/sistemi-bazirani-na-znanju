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
    this.articleService.getRatings(this.id).subscribe(
      res => {
        this.ratings = res;
        this.setRatings();
      }
    );
  }

  get id() {
    return this._id;
  }

  ratings: ArticleRatingDTO[] = [];
  averageRating: number = 0;

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
  }

  private setRatings() {
    this.averageRating = 0;
    const ratingValues: number[] = this.ratings.map(x => x.rating);
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
