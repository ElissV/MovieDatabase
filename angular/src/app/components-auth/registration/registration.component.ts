import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/classes/user/user';
import { Role } from 'src/app/classes/role/role';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    this.registerForm = this.formBuilder.group({
        name: ['', Validators.required],
        email: ['', [Validators.required, Validators.email] ],
        password: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  submitData() {
    if (this.registerForm.valid) {
      this.send();
      this.registerForm.reset();
    } else {
      console.log("Form not submitted");
    }
  }

  send() {
    let url = "http://localhost:8080/registration";
    // let user: User = {
    //   userId: 0,
    //   name: this.registerForm.controls['name'].value,
    //   email: this.registerForm.controls['email'].value,
    //   password: this.registerForm.controls['password'].value,
    //   avatar: "gal.png",
    //   roles: null
    // };
    this.httpClient.post(url, this.registerForm.value).subscribe(
      res => {  
        if (res) {
          console.log("COOL");
        }
      }
    );
  }

}
