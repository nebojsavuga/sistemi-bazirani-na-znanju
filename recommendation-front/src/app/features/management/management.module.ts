import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { AddInjuryComponent } from './add-injury/add-injury.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ManagementRoutingModule } from './management-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';


@NgModule({
  declarations: [
    ProfileComponent,
    EditProfileComponent,
    AddInjuryComponent
  ],
  imports: [
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    CommonModule,
    ManagementRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule
    
  ],
  exports:[
  ]
})
export class ManagementModule { }