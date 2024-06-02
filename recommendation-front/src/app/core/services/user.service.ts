import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environment/environment';
import { LoggedUserProfileDTO } from '../../shared/models/user';
import { CodeDTO } from '../../shared/models/code';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getProfile(): Observable<LoggedUserProfileDTO> {
    return this.http.get<LoggedUserProfileDTO>(environment.apiHost + "users/profile");
  }

  getCodes(): Observable<CodeDTO[]> {
    return this.http.get<CodeDTO[]>(environment.apiHost + "users/codes");
  }
}
