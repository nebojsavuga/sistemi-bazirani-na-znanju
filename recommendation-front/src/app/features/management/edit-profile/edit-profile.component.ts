import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoggedUserProfileDTO } from '../../../shared/models/user';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../core/services/authentication.service';
import { SnackbarService } from '../../../core/services/snackbar.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrl: './edit-profile.component.css'
})
export class EditProfileComponent implements OnInit{
  user: LoggedUserProfileDTO;
  isLoaded = false;
  hasError = false;
  errorValue: string = '';

  public constructor(private router: Router, private service: AuthenticationService, private snackBar: SnackbarService){}

  editProfileForm = new FormGroup(
    {
      height: new FormControl(0, [Validators.required, Validators.min(0), Validators.max(250)]),
      age: new FormControl(0, [Validators.required, Validators.min(0), Validators.max(125)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(3)]),
      gender: new FormControl('', [Validators.required]),
      firstName: new FormControl('', [Validators.required, Validators.minLength(5)])
    }
  );

  ngOnInit(): void {
    const storedValue = localStorage.getItem('userInfo');
      this.user =  JSON.parse(storedValue);
      this.editProfileForm.patchValue({
        height: this.user.height,
        lastName: this.user.lastName,
        firstName: this.user.firstName,
        age:this.user.age,
        gender:this.user.gender
      });
        this.isLoaded = true;
  }

  goBack(){
    localStorage.removeItem('userInfo');
    this.router.navigate(['manage/profile']);
  }

  editProfile(){
    if(!this.editProfileForm.valid){
      this.errorValue = 'Molimo Vas popunite sva polja validno.';
      this.hasError = true;
      return;
    }

    let editUserDTO: LoggedUserProfileDTO = {
      firstName: this.editProfileForm.value.firstName,
      lastName: this.editProfileForm.value.lastName,
      age:this.editProfileForm.value.age,
      height:this.editProfileForm.value.height,
      gender:this.editProfileForm.value.gender
    }
    this.service.editProfile(editUserDTO).subscribe({
      next:(result) =>{
        this.snackBar.showSnackBar('Uspesno ste izmenili profil.', "Ok");
        this.goBack();
      },
      error:(err) =>{
        this.errorValue = err.error;
        this.hasError = true;
      }
    })

    this.hasError = false;
  }
}
