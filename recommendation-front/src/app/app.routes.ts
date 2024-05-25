import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginGuard } from './core/security/login.guard';

const routes: Routes = [
    {path:'', component: AppComponent},
    {path:'login', component: AppComponent, canActivate:[LoginGuard]},
    {path:'register', component: AppComponent, canActivate:[LoginGuard]},
    //{path: 'manage', loadChildren: () => import('./feature/management/management.module').then(m => m.ManagementModule)},
    { path: '', redirectTo: '', pathMatch: 'full'},
    { path: '**', component: AppComponent},
  ];