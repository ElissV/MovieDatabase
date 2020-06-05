import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from 'src/app/classes/film/film';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { Review } from 'src/app/classes/review/review';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  filmId: number;
  currentFilm: Film = new Film();
  filmReviews: Review[];
  dataLoaded: Promise<boolean>;
    
  constructor(private route: ActivatedRoute,
              private filmService: FilmService,
              private genreService: GenreService,
              private reviewService: ReviewService) { 
  }

  ngOnInit(): void {
    this.getFilmId();
    this.getCurrentFilm();
  }

  
  getFilmId() {
     this.route.params.subscribe(
      params => {
        this.filmId = +params['id'];
      }
    );
  }

  getCurrentFilm() {
    this.filmService.getFilm(this.filmId).subscribe(
      data => {
        this.currentFilm = data;
      }
    );
    this.getFilmGenres();
  }

  getFilmGenres() {
    this.genreService.getCurrentFilmGenres(this.filmId).subscribe(
      data => {
        this.currentFilm.genres = data;
      }
    );
    this.dataLoaded = Promise.resolve(true);
  }

  getFilmReviews() {
    this.reviewService.getReviews().subscribe(
      data => {
        this.filmReviews = data;
      }
    );
  }

}
