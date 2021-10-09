import { Component, OnInit } from '@angular/core';
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  today: number = Date.now();

  constructor() {
    setInterval(() => {this.today = Date.now()}, 1);
  }

  ngOnInit(): void {
  }

}
