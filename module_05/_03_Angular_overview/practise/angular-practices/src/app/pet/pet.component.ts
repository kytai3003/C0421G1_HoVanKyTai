import { Component, OnInit } from '@angular/core';
import {Pet} from "./pet";

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'LuLu',
    image: 'https://dogtime.com/assets/uploads/2011/03/puppy-development.jpg'
  };
  constructor() { }

  ngOnInit(): void {
  }

}
