import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeaturesRoutingModule } from './features-routing.module';
import { FiltersComponent } from './filters/filters.component';
import { ArticlesComponent } from './articles/articles.component';
import { ArticleListItemComponent } from './article-list-item/article-list-item.component';
import { ArticleDisplayComponent } from './article-display/article-display.component';
import { StoreHomeComponent } from './store-home/store-home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { CamelCasePipe } from './pipes/camel-case.pipe';
import { ArticlesTypeDisplayComponent } from './articles-type-display/articles-type-display.component';
import { FavoriteDisplayComponent } from './favorite-display/favorite-display.component';
import { AdminArticlesComponent } from './admin-articles/admin-articles.component';
import { RatingDisplayComponent } from './rating-display/rating-display.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { TranslationPipe } from './pipes/translate-pipe.pipe';
import { TemplatesComponent } from './templates/templates.component';
import { PurchasesComponent } from './purchases/purchases.component';
import { ReportsComponent } from './reports/reports.component';
import { RatingArticleComponent } from './rating-article/rating-article.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';

@NgModule({
  declarations: [
    FiltersComponent,
    ArticlesComponent,
    ArticleListItemComponent,
    ArticleDisplayComponent,
    StoreHomeComponent,
    CamelCasePipe,
    TranslationPipe,
    ArticlesTypeDisplayComponent,
    FavoriteDisplayComponent,
    AdminArticlesComponent,
    RatingDisplayComponent,
    AddRatingComponent,
    TemplatesComponent,
    PurchasesComponent,
    ReportsComponent,
    RatingArticleComponent
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    NgxChartsModule
  ],
  exports: [
  ]
})
export class FeaturesModule { }
