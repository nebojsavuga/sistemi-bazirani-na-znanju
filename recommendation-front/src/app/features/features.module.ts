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
import { EditArticleComponent } from './edit-article/edit-article.component';
import { RatingDisplayComponent } from './rating-display/rating-display.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { TranslationPipe } from './pipes/translate-pipe.pipe';


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
    EditArticleComponent,
    RatingDisplayComponent,
    AddRatingComponent
  ],
  imports: [
    CommonModule,
    FeaturesRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatSnackBarModule
  ],
  exports:[
  ]
})
export class FeaturesModule { }
