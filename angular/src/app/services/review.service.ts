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
  filmReviews: Review[] = [];

  constructor(private httpClient: HttpClient) { }

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