import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreHomeComponent } from './store-home/store-home.component';
import { ArticleDisplayComponent } from './article-display/article-display.component';
import { ArticlesTypeDisplayComponent } from './articles-type-display/articles-type-display.component';
import { FavoriteDisplayComponent } from './favorite-display/favorite-display.component';
import { AdminArticlesComponent } from './admin-articles/admin-articles.component';
import { EditArticleComponent } from './edit-article/edit-article.component';
import { TemplatesComponent } from './templates/templates.component';
import { PurchasesComponent } from './purchases/purchases.component';

const routes: Routes = [
  {
    path: '', component: StoreHomeComponent
  },
  {
    path: ':id/article', component: ArticleDisplayComponent
  },
  {
    path: ':type/articles', component: ArticlesTypeDisplayComponent
  },
  {
    path: 'favorite', component: FavoriteDisplayComponent
  },
  {
    path: 'article-management', component: AdminArticlesComponent
  },
  {
    path: 'edit-article/:id', component: EditArticleComponent
  },
  {
    path: 'templates', component: TemplatesComponent
  },
  {
    path: 'purchases', component: PurchasesComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
