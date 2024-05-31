import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../core/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LoggedUserProfileDTO } from '../../../shared/models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{

  constructor(private service: UserService, private router: Router, private activatedRoute: ActivatedRoute){}

  profile: LoggedUserProfileDTO;
  isLoaded = false;
  ngOnInit(): void {
    this.GetProfile();

  }
  editProfile(){
    localStorage.setItem('userInfo', JSON.stringify(this.profile));
    this.router.navigate(['edit'], {relativeTo : this.activatedRoute});

  }

  private GetProfile() {
    this.service.getProfile().subscribe({
      next: (profile) => {
        this.profile = profile;

          this.isLoaded = true;
      },
      error: (err) => {
      }
    });
  }

}
