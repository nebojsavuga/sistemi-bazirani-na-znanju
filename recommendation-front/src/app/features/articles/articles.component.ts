import { Component, Input } from '@angular/core';
import { Filter } from '../../shared/models/filter';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {
  @Input() filters: Filter;
}
