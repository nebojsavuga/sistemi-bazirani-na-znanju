import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginGuard } from './core/security/login.guard';
import { LoginComponent } from './shared/login/login.component';
import { RegisterComponent } from './shared/register/register.component';
import { HomeComponent } from './shared/home/home.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent, canActivate:[LoginGuard]},
  {path:'register', component: RegisterComponent, canActivate:[LoginGuard]},
  //{path:'edit-first-password/:email', component: ChangeFirstPasswordComponent},
  //{path: 'smart', loadChildren: () => import('./feature/smart/smart.module').then(m => m.SmartModule)},
   { path: '', redirectTo: '', pathMatch: 'full'},
  { path: '**', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }