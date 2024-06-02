import { Component } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { TokenDecoderService } from '../../core/services/token-decoder.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm = new FormGroup(
    {
      email: new FormControl('', [Validators.required, Validators.minLength(5), Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    }
  );
  hasError = false;

  constructor(private authenticationService: AuthenticationService,
    private router: Router,
    private tokenDecoderService: TokenDecoderService) {
  }

  login() {
    if (!this.loginForm.valid) { this.hasError = true; return; }
    else this.hasError = false;

    let email: string | null | undefined = this.loginForm.value.email;
    let password: string | null | undefined = this.loginForm.value.password;

    if (email === null || password === null || email === undefined || password == undefined)
      return;


    this.authenticationService.login(email, password).subscribe({
      next: token => {
        this.hasError = false;
        if (token.token) {
          localStorage.setItem("token", token.token);
          localStorage.setItem('role', this.tokenDecoderService.getDecodedAccesToken()['role']);
          localStorage.setItem('userId', this.tokenDecoderService.getDecodedAccesToken()['id']);
          localStorage.setItem('userEmail', this.tokenDecoderService.getDecodedAccesToken()['email']);
          this.router.navigate(['']);
          this.authenticationService.userLoggedIn$.next(true);
          this.authenticationService.role$.next(this.tokenDecoderService.getDecodedAccesToken()['role']);
        }
      },
      error: err => {
        this.hasError = true;
      }
    })
  }
}
