import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, filter } from 'rxjs';
import { Filter } from '../../shared/models/filter';
import { environment } from '../../../environment/environment';
import { RecommendedArticle } from '../../shared/models/articles';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecomendationService {

  constructor(private http: HttpClient) {
  }

  toQueryString(filters: Filter): string {
    let params = new HttpParams();
  
    if (filters.age !== undefined) {
      params = params.append('age', filters.age.toString());
    }
    if (filters.height !== undefined) {
      params = params.append('height', filters.height.toString());
    }
    if (filters.injuries && filters.injuries.length > 0) {
      filters.injuries.forEach(injury => {
        params = params.append('injuries', injury.toString());
      });
    }
    if (filters.level !== undefined) {
      params = params.append('level', filters.level);
    }
    if (filters.sport !== undefined) {
      params = params.append('sport', filters.sport);
    }
    if (filters.typeOfFotballPlayer !== undefined) {
      params = params.append('typeOfFotballPlayer', filters.typeOfFotballPlayer);
    }
    if (filters.typeOfFootball !== undefined) {
      params = params.append('typeOfFootball', filters.typeOfFootball);
    }
    if (filters.typeOfRace !== undefined) {
      params = params.append('typeOfRace', filters.typeOfRace);
    }
    if (filters.typeOfField !== undefined) {
      params = params.append('typeOfField', filters.typeOfField);
    }
    if (filters.typeOfWeightlifting !== undefined) {
      params = params.append('typeOfWeightlifting', filters.typeOfWeightlifting);
    }
    if (filters.gender !== undefined) {
      params = params.append('gender', filters.gender);
    }
  
    // Filter out invalid combinations based on the sport
    switch (filters.sport) {
      case 'Fudbal':
        params = params.delete('typeOfField')
          .delete('typeOfWeightlifting')
          .delete('typeOfRace');
        break;
      case 'Tenis':
        params = params.delete('typeOfFootball')
          .delete('typeOfFotballPlayer')
          .delete('typeOfWeightlifting')
          .delete('typeOfRace');
        break;
      case 'Orijentiring':
        params = params.delete('typeOfFootball')
          .delete('typeOfFotballPlayer')
          .delete('typeOfWeightlifting')
          .delete('typeOfField');
        break;
      case 'DizanjeTegova':
        params = params.delete('typeOfFootball')
          .delete('typeOfFotballPlayer')
          .delete('typeOfField')
          .delete('typeOfRace');
        break;
    }
  
    return params.toString();
  }

  recommend(filters: Filter): Observable<RecommendedArticle[]> {
    filters.age = Number(filters.age);
    filters.height = Number(filters.height);
    if (filters.age === 0) {
      filters.age = undefined;
    }
    if (filters.height === 0) {
      filters.height = undefined;
    }
    if (filters.injuries.length === 0) {
      filters.injuries = undefined;
    }
    if (filters.level === "") {
      filters.level = undefined;
    }
    if (filters.typeOfField === "") {
      filters.typeOfField = undefined;
    }
    if (filters.typeOfFootball === "") {
      filters.typeOfFootball = undefined;
    }
    if (filters.typeOfFotballPlayer === "") {
      filters.typeOfFotballPlayer = undefined;
    }
    if (filters.typeOfRace === "") {
      filters.typeOfRace = undefined;
    }
    if (filters.typeOfWeightlifting === "") {
      filters.typeOfWeightlifting = undefined;
    }
    if (filters.gender === "") {
      filters.gender = undefined;
    }
    if (filters.sport === 'Fudbal') {
      filters.typeOfField = undefined;
      filters.typeOfWeightlifting = undefined;
      filters.typeOfRace = undefined;
    } else if (filters.sport === 'Tenis') {
      filters.typeOfFootball = undefined;
      filters.typeOfFotballPlayer = undefined;
      filters.typeOfWeightlifting = undefined;
      filters.typeOfRace = undefined;
    } else if (filters.sport === 'Orijentiring') {
      filters.typeOfFootball = undefined;
      filters.typeOfFotballPlayer = undefined;
      filters.typeOfWeightlifting = undefined;
      filters.typeOfField = undefined;
    } else if (filters.sport === 'DizanjeTegova') {
      filters.typeOfFootball = undefined;
      filters.typeOfFotballPlayer = undefined;
      filters.typeOfField = undefined;
      filters.typeOfRace = undefined;
    }
    const queryString = this.toQueryString(filters);
    const url = `${environment.apiHost}recommendation?${queryString}`;
    return this.http.get<RecommendedArticle[]>(url);
  }
}