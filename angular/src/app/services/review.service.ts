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



  getAllReviews(): Review[] {
    const url = this.baseUrl + "films/1/filmReviews";

    this.httpClient.get<ReviewWrapper>(url).pipe(
      map(data => data._embedded.reviews))
      .subscribe(data => {
      this.filmReviews = data;
    });
    /*
    this.getReviewsObservable().subscribe( 
        data => this.filmReviews
    )
    data => {
        this.currentFilm.genres = data;
      }

    */
    console.log(this.filmReviews.length);
    return this.setTypesForReviews(this.filmReviews);
  }


  /*getReviewsObservable(): Observable<Review[]> {

    return this.httpClient.get<ReviewWrapper>(url).pipe( 
      map( data => data._embedded.reviews) 
    );
  }*/


  setTypesForReviews(reviewArray: Review[]): Review[] {
    for (let i = 0; i < this.filmReviews.length; i++) {
      let reivewId = reviewArray[i].reviewId;
      this.getReviewType(reivewId).subscribe(
        data => {
          reviewArray[i].reviewType = data;
        }
      );
    }
    return this.filmReviews;
  }


  getAllReviewTypes(): Observable<ReviewType[]> {
    const url = this.baseUrl + "reviewTypes";
    return this.httpClient.get<ReviewTypesWrapper>(url).pipe(
      map(data => data._embedded.reviewTypes)
    );
  }

  getReviewType(reviewId: number): Observable<ReviewType> {
    const url = this.baseUrl + "reviews/" + reviewId + "/reviewType";
    return this.httpClient.get<ReviewType>(url);
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