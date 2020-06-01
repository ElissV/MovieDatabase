import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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
      console.log("Form Submitted!");
      this.registerForm.reset();
    } else {
      console.log("Form not submitted");
    }
  }

  send() {
    let url = "http://localhost:8080/api/register";
    this.httpClient.post(url, this.registerForm);
  }

}