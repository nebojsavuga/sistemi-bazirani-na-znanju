import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../core/services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LoggedUserProfileDTO } from '../../../shared/models/user';
import { InjuryService } from '../../../core/services/injury.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{

  constructor(private service: UserService,private injuryService:InjuryService, private router: Router, private activatedRoute: ActivatedRoute){}

  profile: LoggedUserProfileDTO;
  isLoaded = false;
  injuries = [];
  ngOnInit(): void {
    this.GetProfile();
    this.loadInjuries();

  }
  editProfile(){
    localStorage.setItem('userInfo', JSON.stringify(this.profile));
    this.router.navigate(['edit'], {relativeTo : this.activatedRoute});

  }
  private loadInjuries(): void {
    this.injuryService.getLoggedUserInjuries().subscribe({
      next: (result) => {
        this.injuries = (result);
      },
      error: (err) => {
        // Handle error
      }
    });
  }

  addInjury(){
    this.router.navigate(['add-injury'], {relativeTo : this.activatedRoute});

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
