import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Genre } from '../classes/genre/genre';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private httpClient: HttpClient) { }

  getAllGenres(): Observable<Genre[]> {
    let url = "http://localhost:8080/api/genres/";
    return this.httpClient.get<GenreWrapper>(url).pipe(
      map(data => data._embedded.genres)
    );
  }

}

export class GenreWrapper {
  _embedded: { 
    genres: Genre[] 
  };
}
