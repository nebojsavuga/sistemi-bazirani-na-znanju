import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Token } from "../../shared/models/token";
import { UserProfileDTO, User, RegisteredUser, EditUserDTO, ChangePasswordDTO } from "../../shared/models/user";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  user$ = new BehaviorSubject(null);
  userState$ = this.user$.asObservable();

  userLoggedIn$ = new BehaviorSubject(false);
  userStateLoggedIn$ = this.userLoggedIn$.asObservable();
  constructor(private http: HttpClient) {
    this.user$.next(this.isLoggedIn());
    this.userLoggedIn$.next(this.isLoggedIn());

  }

  isLoggedIn(): boolean {
    return localStorage.getItem('token') != null;

  }
  login(email: string, password: string): Observable<Token> {
    return this.http.post<Token>(environment.apiHost + 'users', { email, password });
  }

  logoutUser(): void {
    localStorage.clear();
    this.userLoggedIn$.next(false);
  }

  registration(newUser: User): Observable<RegisteredUser> {
    return this.http.post<RegisteredUser>(environment.apiHost + "users/register", newUser);
  }

  admineRgistration(newUser: User): Observable<RegisteredUser> {
    return this.http.post<RegisteredUser>(environment.apiHost + "users/register-admin", newUser);
  }

  getProfile(): Observable<UserProfileDTO> {
    return this.http.get<UserProfileDTO>(environment.apiHost + "users/profile");
  }

  getPicture(imagePath: string): Observable<Blob> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    return this.http.get('http://localhost/' + imagePath, {
      headers: headers,
      responseType: 'blob',
      withCredentials: true  // Ensure credentials are sent with the request
    });
  }


  editProfile(userInfo: EditUserDTO): Observable<EditUserDTO> {
    return this.http.put<EditUserDTO>(environment.apiHost + "users/edit-profile", userInfo);
  }
  editPassword(passwordInfo: ChangePasswordDTO): Observable<boolean> {
    return this.http.put<boolean>(environment.apiHost + "users/edit-password", passwordInfo);
  }

  editFirstPassword(passwordInfo: ChangePasswordDTO, email: string): Observable<Token> {
    return this.http.put<Token>(environment.apiHost + "users/edit-first-password?email=" + email, passwordInfo);
  }

  isPasswordNotChanged(): boolean {
    return localStorage.getItem('passwordChanged') != null;
  }
}
