import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../core/services/authentication.service';
import { TokenDecoderService } from '../../core/services/token-decoder.service';
import { User } from '../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(3)]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    repeatedPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
    height: new FormControl('', [Validators.min(90), Validators.max(300)]),
    age: new FormControl('', [Validators.min(3), Validators.max(120)]),
    gender: new FormControl('', [Validators.required])
  });

  constructor(private authenticationService: AuthenticationService, protected decodeService: TokenDecoderService) {  }

  get password() { return this.registerForm.get('password'); }
  get repeatedPassword() { return this.registerForm.get('repeatedPassword'); }
  hasError = false;
  errorValue = '';
  successMessage = '';
  successfullyRegistered = false;

  register(): void {
    if (!this.registerForm.valid) {
      this.hasError = true;
      this.errorValue = "Nisu sva polja ispravno uneta.";
    }
    if (this.password.value !== this.repeatedPassword.value) {
      this.hasError = true;
      this.errorValue = "Lozinke se ne podudaraju";
      return;
    }

    if (this.registerForm.valid) {
      const user: User = {
        email: this.registerForm.value.email,
        lastName: this.registerForm.value.lastName,
        firstName: this.registerForm.value.name,
        password: this.registerForm.value.password,
        repeatPassword: this.registerForm.value.repeatedPassword,
        height: Number.parseFloat(this.registerForm.value.height),
        age: Number.parseInt(this.registerForm.value.age),
        gender: this.registerForm.value.gender
      }

      this.authenticationService.registration(user).subscribe({
        next: _ => {
          this.hasError = false;
          this.successfullyRegistered = true;
          this.successMessage = "Successfully registered.";
        }, error: err => {
          this.hasError = true;
          this.errorValue = 'All fields must be filled correctly';
        }
      })
    } else {
      this.hasError = true;
      this.errorValue = 'All fields must be filled correctly';

    }
  }

}
