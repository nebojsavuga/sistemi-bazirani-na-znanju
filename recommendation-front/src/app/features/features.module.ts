import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeaturesRoutingModule } from './features-routing.module';
import { FiltersComponent } from './filters/filters.component';
import { ArticlesComponent } from './articles/articles.component';


@NgModule({
  declarations: [
    FiltersComponent,
    ArticlesComponent
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule
  ]
})
export class FeaturesModule { }
