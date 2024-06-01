import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';

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


  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
  }

  setRating(rating: number) {
    this.articleService.rateArticle(this._id, rating).subscribe(
      {
        next:(_) =>{
          this.rated.emit(true);
        },
        error:(err) =>{

        }
      }
    )
  }

}
