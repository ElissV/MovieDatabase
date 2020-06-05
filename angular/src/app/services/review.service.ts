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

  constructor(private httpClient: HttpClient) { }


  getReviews(): Observable<Review[]> {
    const url = this.baseUrl + "reviews";
    return this.httpClient.get<ReviewWrapper>(url).pipe(
      map(data => data._embedded.reviews)
    );
  }


  getReviewTypes(): Observable<ReviewType[]> {
    const url = this.baseUrl + "reviewTypes";
    return this.httpClient.get<ReviewTypesWrapper>(url).pipe(
      map(data => data._embedded.reviewTypes)
    );
  }

}

export class ReviewWrapper {
  _embedded: {
    reviews: Review[];
  };
}

export class ReviewTypesWrapper {
  _embedded: {
    reviewTypes: ReviewType[];
  };
}