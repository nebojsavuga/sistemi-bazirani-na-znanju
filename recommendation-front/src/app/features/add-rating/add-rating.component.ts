import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrl: './add-rating.component.css'
})
export class AddRatingComponent {

  _id: number;
  @Output() rated: EventEmitter<any> = new EventEmitter<boolean>();

  @Input() set id(value: number) {
    this._id = value;
  }
  get id() {
    return this.id;
  }


  constructor(private articleService: ArticleService,
    private snackbar: SnackbarService
  ) { }

  ngOnInit(): void {
  }

  setRating(rating: number) {
    this.articleService.rateArticle(this._id, rating).subscribe(
      {
        next:(_) =>{
          this.rated.emit(true);
          this.snackbar.showSnackBar('Successfully rated the article.', 'Ok');
        },
        error:(err) =>{
            this.snackbar.showSnackBar('There was an error.', 'Ok');
        }
      }
    )
  }
  handleMouseEnter(rating: number): void {
    this.updateStarRatings(rating);
  }
  updateStarRatings(rating: number): void {
    for (let i = 1; i <= 5; i++) {
      const star = document.getElementById(`rating${i}${i}`);
      if (star) {
        if (i <= rating) {
          star.classList.add('checked');
        } else {
          star.classList.remove('checked');
        }
      }
    }
  }
  handleMouseExit(): void {
    this.updateStarRatings(0);
  }
}
