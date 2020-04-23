import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FilmListComponent } from './components/film-list/film-list.component';
import { FilmComponent } from './components/film/film.component';


const routes: Routes = [
  {path: 'films', component: FilmListComponent},
  {path: 'films/:id', component: FilmComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
