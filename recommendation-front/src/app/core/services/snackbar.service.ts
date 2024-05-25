import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  constructor(private snackBar: MatSnackBar) { }

  showSnackBar(message: string, action: string){
    const _ = this.snackBar.open(message, action, {
      duration: 5000,
    });
  }
}
