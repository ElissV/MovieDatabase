import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FilmListComponent } from './components-general/film-list/film-list.component';
import { FilmComponent } from './components-general/film/film.component';
import { RegistrationComponent } from './components-auth/registration/registration.component';
import { LoginComponent } from './components-auth/login/login.component';


const routes: Routes = [
  {path: 'films', component: FilmListComponent},
  {path: 'films/top', component: FilmListComponent},
  {path: 'films/:id', component: FilmComponent},
  {path: 'genres/:id/films', component: FilmListComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/films', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
