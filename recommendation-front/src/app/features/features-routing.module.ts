import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreHomeComponent } from './store-home/store-home.component';
import { ArticleDisplayComponent } from './article-display/article-display.component';

const routes: Routes = [
  {
    path: '', component: StoreHomeComponent
  },
  {
    path: ':id/article', component: ArticleDisplayComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
