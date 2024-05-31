import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environment/environment';
import { LoggedUserProfileDTO } from '../../shared/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getProfile(): Observable<LoggedUserProfileDTO> {
    return this.http.get<LoggedUserProfileDTO>(environment.apiHost + "users/profile");
  }
}
