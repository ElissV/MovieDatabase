import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../classes/review/review';
import { HttpClient } from '@angular/common/http';
import { ReviewType } from '../classes/review-type/review-type';
import { map } from 'rxjs/operators';
import { FormGroup } from '@angular/forms';
import { FilmsWrapper, FilmService } from './film.service';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  baseUrl = "http://localhost:8080/api/";

  constructor(private http: HttpClient,
              private filmService: FilmService) { }

  
  getReviewsByFilmId(film: number) {
    const url = this.baseUrl + "films/" + film + "/filmReviews";
    return this.http.get<ReviewsWrapper>(url).pipe(
      map(
        data => data._embedded.reviews
      )
    );
  }

  getReviewsByFilmAndTypeIds(film: number, type: number) {
    const url = this.baseUrl 
          + "reviews/search/findByFilmIdAndReviewTypeId?"
          + "filmId=" + film + "&typeId=" + type;
    return this.http.get<ReviewsWrapper>(url).pipe(
      map(
        data => data._embedded.reviews
      )
    );
  }

  submitReview(typeId:number, text: string, filmId: number) {
    const review = this.getReviewObject(typeId, filmId);
    const url = this.baseUrl + "/reviews";
    this.http.put<Review>(url, review);
    console.log("PUT");
  }

  getReviewObject(typeId: number, filmId: number): Review {
    const type = this.getCertainType(typeId).subscribe();
    let review = new Review();
    review.film = this.filmService.getFilm(filmId).subscribe();
  }
  
  getAllReviewTypes(): Observable<ReviewType[]> {
    const url = this.baseUrl + "reviewTypes";
    return this.http.get<ReviewTypesWrapper>(url).pipe(
      map(
        data => data._embedded.reviewTypes
      )
    );
  }

  getCertainType(id: number): Observable<ReviewType> {
    const url = this.baseUrl + "reviewTypes" + id;
    return this.http.get<ReviewType>(url);
  }

}

export class ReviewsWrapper {
  _embedded: {
    reviews: Review[];
  };
}

export class ReviewTypesWrapper {
  _embedded: {
    reviewTypes: ReviewType[];
  };
}