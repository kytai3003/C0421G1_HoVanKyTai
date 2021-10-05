import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SignUpFormComponent } from './sign-up-form/sign-up-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { SignInFormComponent } from './sign-in-form/sign-in-form.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpFormComponent,
    SignInFormComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
