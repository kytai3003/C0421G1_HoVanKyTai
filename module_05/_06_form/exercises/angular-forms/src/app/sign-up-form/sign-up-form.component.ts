import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormsModule, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-sign-up-form',
  templateUrl: './sign-up-form.component.html',
  styleUrls: ['./sign-up-form.component.css']
})
export class SignUpFormComponent implements OnInit {

  registerForm: FormGroup;


  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl("", [Validators.required, Validators.email]),
      password1: new FormControl("", [Validators.required, Validators.minLength(6)]),
      password2: new FormControl("", [Validators.required, Validators.minLength(6)]),
      country: new FormControl("Vietnam", Validators.required),
      age: new FormControl("", [Validators.required, Validators.min(18), Validators.max(150)]),
      gender: new FormControl("", Validators.required),
      phone: new FormControl("", [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
      }
    )
  };

  ngOnInit(): void {
  }


  createAccount() {
    if (this.registerForm.value.password1 != this.registerForm.value.password2) {
        alert("Not same password.");
    } else {
      alert("Registered.");
      console.log(this.registerForm);
    }

  }
}
