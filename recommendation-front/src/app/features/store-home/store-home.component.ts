import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-store-home',
  templateUrl: './store-home.component.html',
  styleUrl: './store-home.component.css'
})
export class StoreHomeComponent {

  handleFilterSubmit(event: any) {
    console.log(event);
  }
}
