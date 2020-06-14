import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from 'src/app/classes/film/film';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { Review } from 'src/app/classes/review/review';
import { ReviewService } from 'src/app/services/review.service';
import { ReviewType } from 'src/app/classes/review-type/review-type';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  filmId: number;
  currentFilm: Film = new Film;
  reviews: Review[];
  allReviewTypes: ReviewType[];
  dataLoaded: Promise<boolean>;
    
  constructor(private route: ActivatedRoute,
              private filmService: FilmService,
              private genreService: GenreService,
              private reviewService: ReviewService) { 
  }

  ngOnInit(): void {
    this.getFilmId();
    this.getCurrentFilm();
    this.getReviewTypes();
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
        this.reviews = this.currentFilm.filmReviews;
      }
    );
  }

  filterReviews(reviewTypeId: number) {
    if (reviewTypeId == -1) {
      this.reviews = this.currentFilm.filmReviews;
    } else {
      this.reviewService.getReviewsByFilmAndTypeIds(this.filmId, reviewTypeId)
          .subscribe(
            data => {
              this.reviews = data;
            } 
          );
    }
  }

  getReviewTypes() {
    this.reviewService.getAllReviewTypes().subscribe(
      data => {
        this.allReviewTypes = data;
      }
    );
  }

}
