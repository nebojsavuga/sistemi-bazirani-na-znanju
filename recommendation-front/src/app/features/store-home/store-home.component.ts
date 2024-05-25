import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { RecomendationService } from '../../core/services/recomendation.service';

@Component({
  selector: 'app-store-home',
  templateUrl: './store-home.component.html',
  styleUrl: './store-home.component.css'
})
export class StoreHomeComponent {

  constructor(private recomendationService: RecomendationService) { }

  handleFilterSubmit(event: any) {
    
    this.recomendationService.recommend(event).subscribe(
      res =>{
        console.log(res);
      }
    )
  }
}
