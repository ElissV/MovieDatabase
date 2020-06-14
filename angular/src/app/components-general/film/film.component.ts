import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from 'src/app/classes/film/film';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { Review } from 'src/app/classes/review/review';
import { ReviewService } from 'src/app/services/review.service';
import { ReviewType } from 'src/app/classes/review-type/review-type';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  reviewForm: FormGroup;
    
  constructor(private route: ActivatedRoute,
              private filmService: FilmService,
              private genreService: GenreService,
              private reviewService: ReviewService,
              private formBuilder: FormBuilder) { 
  }

  ngOnInit(): void {
    this.getFilmId();
    this.getCurrentFilm();
    this.getReviewTypes();
    this.initializeForm();
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

  initializeForm() {
    this.reviewForm = this.formBuilder.group({
      type: ['', [Validators.required]],
      text: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  sendReview() {
    const typeId = this.reviewForm.controls['type'].value;
    const text = this.reviewForm.controls['text'].value;
    this.reviewService.submitReview(typeId, text, this.filmId);
  }

}
