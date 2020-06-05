import { Component, OnInit } from '@angular/core';
import { FilmService } from 'src/app/services/film.service';
import { Film } from 'src/app/classes/film/film';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css']
})
export class FilmListComponent implements OnInit {

  films: Film[] = [];
  currentGenreId: number;

  constructor(private filmService: FilmService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getFilms();
  }


  getFilms() {
    
    const hasGenreId: boolean = this.route.snapshot.paramMap.has('id');
    if (hasGenreId) {
      this.getFilmsByGenre();
    } else {
      this.getAllFilms();
    }

  }

  getFilmsByGenre() {
    this.currentGenreId = +this.route.snapshot.paramMap.get('id');
    this.filmService.getFilmsByGenre(this.currentGenreId).subscribe(
      data => {
        this.films = data;
      }
    );
  }

  getAllFilms() {
    this.filmService.getAllFilms().subscribe(
        data => {
          this.films = data;
        }
      );
  }

}
