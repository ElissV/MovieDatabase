import { Component, OnInit } from '@angular/core';
import { GenreService } from 'src/app/services/genre.service';
import { Genre } from 'src/app/classes/genre/genre';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  
  genres: Genre[];
  
  constructor(private genreService: GenreService) { }

  ngOnInit(): void {
    this.getGenres();
  }

  getGenres() {
    this.genreService.getAllGenres().subscribe(
      data => {
        this.genres = data;
      }
    );

    let str = of(3);
    str
    .pipe(
      map(
        name => name * 2
      )
    )
    .subscribe(
      data => console.log(data)
    );
  }

}
