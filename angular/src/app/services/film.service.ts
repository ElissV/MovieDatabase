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
    const filmUrl = this.baseUrl + id + "?projection=filmProjection";
    return this.http.get<Film>(filmUrl);
  }

  getFilmsByGenre(id: number): Observable<Film[]> {
    const url = "http://localhost:8080/api/films/search/findByGenres_genreId?id=" + id;
    return this.getFilms(url);
  }

  getFilms(url: string): Observable<Film[]> {
    return this.http.get<FilmsWrapper>(url).pipe(
      map(data => data._embedded.films)
    );
  }

  getTopTen() {
    const url = "http://localhost:8080/api/films/search/OrderByRatingDesc?size=10";
    return this.http.get<FilmsWrapper>(url).pipe(
      map(data => data._embedded.films)
    );
  }

  getFilmsByGenreAndOrder(genreId: number, order: string): Observable<Film[]> {
    if (order == 'Asc') {
      return this.getFilmsByGenreAsc(genreId);
    } else if (order == 'Desc') {
      return this.getFilmsByGenreDesc(genreId);
    } else if (order == 'none') {
      return this.getFilmsByGenre(genreId);
    }
  }

  sortFilmsByRating(value: string): Observable<Film[]> {
    const url = "http://localhost:8080/api/films/search/OrderByRating" + value;
    return this.http.get<FilmsWrapper>(url).pipe(
      map(data => data._embedded.films)
    );
  }

  private getFilmsByGenreAsc(genreId: number): Observable<Film[]>  {
    const url = this.baseUrl + 
                "search/findByGenres_genreIdOrderByRatingAsc?id=" + genreId;
    return this.http.get<FilmsWrapper>(url).pipe(
      map(data => data._embedded.films)
    );
  }
  
  private getFilmsByGenreDesc(genreId: number): Observable<Film[]>  {
    const url = this.baseUrl + 
                "search/findByGenres_genreIdOrderByRatingDesc?id=" + genreId;
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