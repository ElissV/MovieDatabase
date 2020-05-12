import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from 'src/app/classes/film/film';
import { FilmService } from 'src/app/services/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  filmId: number;
  currentFilm: Film;
    
  constructor(private route: ActivatedRoute,
              private filmService: FilmService) { 
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
  }

}
