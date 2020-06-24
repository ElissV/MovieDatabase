import { Component, OnInit, Input } from '@angular/core';
import { GenreService } from 'src/app/services/genre.service';
import { Genre } from 'src/app/classes/genre/genre';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { isNumber } from 'util';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  genres: Genre[];
  genreChosen: string = '';
  
  constructor(private genreService: GenreService,
              private router: Router) { }

  ngOnInit(): void {
    this.getGenres();
  }

  getGenres() {
    this.genreService.getAllGenres().subscribe(
      data => {
        this.genres = data;
      }
    );
  }

}
