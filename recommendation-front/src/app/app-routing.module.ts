import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginGuard } from './core/security/login.guard';

const routes: Routes = [
  {path:'', component: AppComponent},
  {path:'login', component: AppComponent, canActivate:[LoginGuard]},
  {path:'register', component: AppComponent, canActivate:[LoginGuard]},
  //{path:'edit-first-password/:email', component: ChangeFirstPasswordComponent},
  //{path: 'smart', loadChildren: () => import('./feature/smart/smart.module').then(m => m.SmartModule)},
   { path: '', redirectTo: '', pathMatch: 'full'},
  { path: '**', component: AppComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }