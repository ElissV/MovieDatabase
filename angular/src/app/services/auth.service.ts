import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { User } from '../classes/user/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userLoggedIn: Observable<User>;

  constructor(private http: HttpClient) { }

  public checkCredentials(form: FormGroup) {
    const email = form.controls['email'].value;
    const password = form.controls['password'].value;
    const url = "http://localhost:8080/api/users/search/findByEmailAndPassword?" +
                  "email=" + email + "&password=" + password;
     this.userLoggedIn = this.http.get<User>(url);
     return this.userLoggedIn;
  }

  // public getUserRole(): Observable<Role> {
  //   return this.http.get
  // }

}
