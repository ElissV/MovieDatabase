import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Film } from '../classes/film';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  films: Film[] = [];

  constructor(private http: HttpClient) { }

  getFilms(): Observable<Film[]> {
    let baseUrl = 'http://localhost:8080/api/films';
    return this.http.get<FilmWrapper>(baseUrl).pipe(
      map(data => data._embedded.films)
    );
  }

}

export class FilmWrapper {
  _embedded: { films: Film[] };
}