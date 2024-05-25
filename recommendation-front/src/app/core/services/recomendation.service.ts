import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, filter } from 'rxjs';
import { Filter } from '../../shared/models/filter';
import { environment } from '../../../environment/environment';
import { RecommendedArticle } from '../../shared/models/articles';

@Injectable({
  providedIn: 'root'
})
export class RecomendationService {

  constructor(private http: HttpClient) {
  }

  recommend(filters: Filter): Observable<RecommendedArticle[]> {
    filters.age = Number(filters.age);
    filters.height = Number(filters.height);
    if(filters.age === 0){
      filters.age = undefined;
    }
    if(filters.height === 0){
      filters.height = undefined;
    }
    if(filters.injuries.length === 0){
      filters.injuries = undefined;
    }
    if(filters.level === ""){
      filters.level = undefined;
    }
    if(filters.typeOfField === ""){
      filters.typeOfField = undefined;
    }
    if(filters.typeOfFootball === ""){
      filters.typeOfFootball = undefined;
    }
    if(filters.typeOfFotballPlayer === ""){
      filters.typeOfFotballPlayer = undefined;
    }
    if(filters.typeOfRace === ""){
      filters.typeOfRace = undefined;
    }
    if(filters.typeOfWeightlifting === ""){
      filters.typeOfWeightlifting = undefined;
    }
    if(filters.gender === ""){
      filters.gender = undefined;
    }
    return this.http.put<RecommendedArticle[]>(environment.apiHost + 'recommendation', filters);
  }
}
