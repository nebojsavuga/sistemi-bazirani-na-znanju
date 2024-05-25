import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Injury } from '../../shared/models/injury';
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
}
