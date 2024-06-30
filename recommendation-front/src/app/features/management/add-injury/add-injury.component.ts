import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SnackbarService } from '../../../core/services/snackbar.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { InjuryService } from '../../../core/services/injury.service';
import { InjuryDTO } from '../../../shared/models/injury';

@Component({
  selector: 'app-add-injury',
  templateUrl: './add-injury.component.html',
  styleUrl: './add-injury.component.css'
})
export class AddInjuryComponent implements OnInit {
  public constructor(private router: Router, private service: InjuryService, private snackBar: SnackbarService) { }
  errorMessage: string | null = null;
  injury: InjuryDTO;
  injuryForm = new FormGroup(
    {
      injury: new FormControl('', [Validators.required]),
      date: new FormControl()
    }
  );
  isLoaded = true;
  injuries = [];
  goBack() {

    this.router.navigate(['manage/profile']);
  }

  deleteInjury(injuryId: number): void {
    this.service.deleteUserInjury(injuryId).subscribe({
      next: (result) => {
        this.loadInjuries()
        this.snackBar.showSnackBar('Successfully deleted injury.', "Ok");
      },
      error: (err) => {
        this.loadInjuries()
        this.snackBar.showSnackBar('Successfully deleted injury.', "Ok");
      }
    })
  }

  private loadInjuries(): void {
    this.service.getLoggedUserInjuries().subscribe({
      next: (result) => {
        this.injuries = (result);
      },
      error: (err) => {
        // Handle error
      }
    });
  }

  dateInPastValidator() {
    return (control) => {
      const selectedDate = control.value;
      const currentDate = new Date();
      if (selectedDate > currentDate) {
        return { futureDate: true };
      }
      if (selectedDate == null) {
        return { futureDate: true };
      }
      return null;
    };
  }

  Submit() {
    let localStartDate = this.injuryForm.value.date;
    const today = new Date();
    if (localStartDate > today) {
      this.errorMessage = "Injury date must be in the past."
      return
    }
    if (localStartDate == null || localStartDate == "") {
      this.errorMessage = "Enter injury date."
      return
    }
    this.errorMessage = null
    let injuryDTO: InjuryDTO = {
      executionTime: this.injuryForm.value.date,
      injury: this.injuryForm.value.injury,
    }
    this.service.AddInjury(injuryDTO).subscribe({
      next: (result) => {
        this.snackBar.showSnackBar('Successfully added new injury.', "Ok");
        this.goBack();
      },
      error: (err) => {
        console.log(err.error);
      }
    })

  }
  ngOnInit(): void {
    this.loadInjuries();
    this.injuryForm.patchValue({
      injury: 'Povreda skocnog zgloba'
    });
  }
}
