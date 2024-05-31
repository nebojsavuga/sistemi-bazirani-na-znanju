import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Injury, InjuryDTO } from '../../shared/models/injury';
import { Observable } from 'rxjs';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class InjuryService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Injury[]> {
    return this.http.get<Injury[]>(environment.apiHost + 'injuries');
  }
  AddInjury(injury: InjuryDTO): Observable<string> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<string>(`${environment.apiHost}users/add-injury`, injury, {
      headers: headers,
      responseType: 'text' as 'json'
    });
  }
}
