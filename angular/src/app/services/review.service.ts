import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../classes/review/review';
import { HttpClient } from '@angular/common/http';
import { ReviewType } from '../classes/review-type/review-type';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  baseUrl = "http://localhost:8080/api/";

  constructor(private http: HttpClient) { }

  getAllReviewTypes(): Observable<ReviewType[]> {
    const url = this.baseUrl + "reviewTypes";
    return this.http.get<ReviewTypesWrapper>(url).pipe(
      map(
        data => data._embedded.reviewTypes
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

  getReviewsByFilmId(film: number) {
    const url = this.baseUrl + "films/" + film + "/filmReviews";
    return this.http.get<ReviewsWrapper>(url).pipe(
      map(
        data => data._embedded.reviews
      )
    );
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