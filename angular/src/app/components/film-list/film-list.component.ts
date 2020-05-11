import { Component, OnInit } from '@angular/core';
import { FilmService } from 'src/app/services/film.service';
import { Film } from 'src/app/classes/film';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css']
})
export class FilmListComponent implements OnInit {

  films: Film[] = [];

  constructor(private filmService: FilmService) { }

  ngOnInit(): void {
    this.filmService.getAllFilms().subscribe(
      data => {
        this.films = data;
      }
    );
  }


}
