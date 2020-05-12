import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Film } from '../classes/film/film';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  baseUrl = 'http://localhost:8080/api/films/';
  films: Film[] = [];
  film: Film;

  constructor(private http: HttpClient) { }

  getAllFilms(): Observable<Film[]> {
    return this.http.get<FilmsWrapper>(this.baseUrl).pipe(
      map(data => data._embedded.films)
    );
  }

  getFilm(id: number): Observable<Film> {
    let filmUrl = this.baseUrl + id;
    return this.http.get<Film>(filmUrl);
  }

}

export class FilmsWrapper {
  _embedded: { films: Film[] };
}