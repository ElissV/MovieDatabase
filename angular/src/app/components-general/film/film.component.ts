import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from 'src/app/classes/film/film';
import { FilmService } from 'src/app/services/film.service';
import { GenreService } from 'src/app/services/genre.service';
import { Review } from 'src/app/classes/review/review';
import { ReviewService } from 'src/app/services/review.service';
import { ReviewType } from 'src/app/classes/review-type/review-type';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';

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
  reviewSubmitMsg: string = '';

  reviewForm: FormGroup = this.formBuilder.group({
    film: this.filmId,
    type: ['', [Validators.required]],
    text: ['', [Validators.required, Validators.minLength(10)]]
  });
  
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
    console.log(this.allReviewTypes[0]);
  }

  initializeForm() {
    this.reviewForm = this.formBuilder.group({
      filmId: this.filmId,
      reviewTypeId: [null, [Validators.required]],
      text: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  sendReview() {
    this.reviewSubmitMsg = this.reviewService.sendReviewForm(this.reviewForm);
    console.log(this.reviewForm.value);
    this.reviewForm.reset();
  }

}
