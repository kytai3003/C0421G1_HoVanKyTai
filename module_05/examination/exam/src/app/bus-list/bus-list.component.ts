import { Component, OnInit } from '@angular/core';
import {Bus} from "../model/Bus";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {BusService} from "../service/bus.service";

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit {

  p: number = 1;

  busList: Bus[];


  busFather: Bus;

  constructor(private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient,
              private busService: BusService) {
    // this.customerService.findAll().subscribe(next => {
    //   this.customerList = next;
    //   console.log(this.customerFather);
    // })
  }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:3000/bus').subscribe((result: Bus[]) => {
      this.busList = result;
      console.log(this.busList);
    })
  }

  showDetail(bus: Bus) {
    this.busFather = bus;
  }


  key: string = 'customerCode';
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
