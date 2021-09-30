import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AngularCalculatorAppComponent } from './angular-calculator-app/angular-calculator-app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ColorComponent } from './color/color.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularCalculatorAppComponent,
    ColorComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
