import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SnackbarService } from '../../../core/services/snackbar.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../../core/services/user.service';
import { InjuryService } from '../../../core/services/injury.service';
import { InjuryDTO } from '../../../shared/models/injury';

@Component({
  selector: 'app-add-injury',
  templateUrl: './add-injury.component.html',
  styleUrl: './add-injury.component.css'
})
export class AddInjuryComponent implements OnInit{
  public constructor(private router: Router, private service: InjuryService, private snackBar: SnackbarService){}
  errorMessage: string | null = null;
  injury:InjuryDTO;
  povredaForm = new FormGroup(
    {
      povreda: new FormControl('', [Validators.required]),
      date: new FormControl()
    }
  );
  isLoaded = true;
 
  goBack(){
    
    this.router.navigate(['manage/profile']);
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

  Submit(){
    let localStartDate = this.povredaForm.value.date;
    const today = new Date();
    if(localStartDate > today){
      this.errorMessage = "Datum povrede mora da bude u proslosti."
      return
    }
    if(localStartDate == null || localStartDate == ""){
      this.errorMessage = "Morate izabrati datum povrede."
      return
    }
    this.errorMessage = null
    let injuryDTO: InjuryDTO = {
      executionTime: this.povredaForm.value.date,
      injury: this.povredaForm.value.povreda,
    }
    this.service.AddInjury(injuryDTO).subscribe({
      next:(result) =>{
        this.snackBar.showSnackBar('Uspesno ste dodali novu povredu.', "Ok");
        this.goBack();
      },
      error:(err) =>{
        console.log(err.error);
      }
    })

  }
  ngOnInit(): void {
    this.povredaForm.patchValue({
      povreda: 'Povreda skocnog zgloba'
    });
  }

  
}
