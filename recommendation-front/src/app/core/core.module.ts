import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatSnackBarModule,
    AppRoutingModule
  ],
  exports: []
})
export class CoreModule { }
