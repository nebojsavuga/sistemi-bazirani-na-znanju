import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AddInjuryComponent } from './add-injury/add-injury.component';

const routes: Routes = [
    {path: "profile", component: ProfileComponent},
    {path: "profile/edit", component: EditProfileComponent},
    {path: "profile/add-injury", component: AddInjuryComponent}
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class ManagementRoutingModule { }