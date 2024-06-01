import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleRatingDTO, FullArticle, RecommendedArticle } from '../../shared/models/articles';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  getTypeOfArticle(article: FullArticle): string {
    if (article.ballType || article.typeOfFootballGear || article.numberOfCramponsFootballShoeCrampons || article.numberOfCramponsGrassFootballShoe) {
      return 'fudbal';
    }
    if (article.barbelType || article.barbellWeight || article.dumbellWeight || article.elasticBandWeight || article.weightliftingGloveSize || article.weightliftingTypeOfGear || article.weightliftingWeight) {
      return 'dizanjeTegova';
    }
    if (article.sweatpantsType || article.typeOfOrientiringGear) {
      return 'orijentiring';
    }
    return 'tenis';
  }

  constructor(private http: HttpClient) { }

  getById(id: number): Observable<FullArticle> {
    return this.http.get<FullArticle>(environment.apiHost + 'articles/' + String(id));
  }

  getByType(typeOfArticle: string): Observable<RecommendedArticle[]> {
    return this.http.get<RecommendedArticle[]>(environment.apiHost + 'articles/type?type=' + typeOfArticle);
  }

  buy(id: number, codeId: number | undefined): Observable<FullArticle> {
    let requestParam = '';
    if(codeId !== undefined && codeId !== 0){
      requestParam = '?codeId=' + String(codeId);
    }
    return this.http.post<FullArticle>(environment.apiHost + 'articles/buy/' + String(id) + requestParam, {});
  }

  addToFavorite(id: number): Observable<string> {
    return this.http.put<string>(environment.apiHost + 'users/favorite-article/' + String(id), {});
  }

  getFavorites(): Observable<RecommendedArticle[]> {
    return this.http.get<RecommendedArticle[]>(environment.apiHost + 'users/favorite-articles');
  }

  deleteFavorite(id: number): Observable<boolean> {
    return this.http.delete<boolean>(environment.apiHost + 'users/favorite-articles/' + String(id));
  }


  getAll(): Observable<RecommendedArticle[]> {
    return this.http.get<RecommendedArticle[]>(environment.apiHost + 'articles');
  }

  getRatings(id: number): Observable<ArticleRatingDTO[]> {
    return this.http.get<ArticleRatingDTO[]>(environment.apiHost + 'articles/rate/' + String(id));
  }

  rateArticle(articleId: number, rating: number): Observable<void> {
    return this.http.post<void>(environment.apiHost + 'articles/rate', { articleId: articleId, rating: rating });
  }
}
