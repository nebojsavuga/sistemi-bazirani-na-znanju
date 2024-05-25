import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeaturesRoutingModule } from './features-routing.module';
import { FiltersComponent } from './filters/filters.component';
import { ArticlesComponent } from './articles/articles.component';
import { ArticleListItemComponent } from './article-list-item/article-list-item.component';
import { ArticleDisplayComponent } from './article-display/article-display.component';


@NgModule({
  declarations: [
    FiltersComponent,
    ArticlesComponent,
    ArticleListItemComponent,
    ArticleDisplayComponent
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule
  ]
})
export class FeaturesModule { }
