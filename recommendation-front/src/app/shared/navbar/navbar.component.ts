import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { Router } from '@angular/router';
import { TokenDecoderService } from '../../core/services/token-decoder.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  isLoggedIn: boolean = false;

  constructor(private authenticationService: AuthenticationService, private router: Router, protected decodeService: TokenDecoderService) {

  }
  ngOnInit(): void {
    this.authenticationService.userStateLoggedIn$.subscribe(res => {
      this.isLoggedIn = res;
      if (!this.isLoggedIn) {
        this.router.navigate(['']);
      }
    })
  }

  logout(): void {
    localStorage.clear();
    this.authenticationService.logoutUser();
  }
}
