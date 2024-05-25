import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FullArticle } from '../../shared/models/articles';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) { }

  getById(id: number): Observable<FullArticle>{
    return this.http.get<FullArticle>(environment.apiHost + 'articles/' + String(id));
  }
}
