import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreHomeComponent } from './store-home/store-home.component';
import { ArticleDisplayComponent } from './article-display/article-display.component';
import { ArticlesTypeDisplayComponent } from './articles-type-display/articles-type-display.component';

const routes: Routes = [
  {
    path: '', component: StoreHomeComponent
  },
  {
    path: ':id/article', component: ArticleDisplayComponent
  },
  {
    path: ':type/articles', component: ArticlesTypeDisplayComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
