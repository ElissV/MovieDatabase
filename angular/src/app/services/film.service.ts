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

  constructor(private http: HttpClient) { }

  getAllFilms(): Observable<Film[]> {
    return this.getFilms(this.baseUrl);
  }

  getFilm(id: number): Observable<Film> {
    let filmUrl = this.baseUrl + id;
    return this.http.get<Film>(filmUrl);
  }

  getFilmsByGenre(id: number): Observable<Film[]> {
    let url = "http://localhost:8080/api/genres/" + id + "/films";
    return this.getFilms(url);
  }

  getFilms(url: string): Observable<Film[]> {
    return this.http.get<FilmsWrapper>(url).pipe(
      map(data => data._embedded.films)
    );
  }

}

export class FilmsWrapper {
  _embedded: { 
    films: Film[] 
  };
}