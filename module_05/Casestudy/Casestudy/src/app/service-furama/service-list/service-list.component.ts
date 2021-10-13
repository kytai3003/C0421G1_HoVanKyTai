import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Service} from "../../../models/service/Service";
import {ServiceService} from "../../service/service.service";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  p: number = 1;

  serviceList: Service[];


  serviceFather: Service;
  searchValue: string;

  constructor(private serviceService: ServiceService,
              private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient) {
    // this.customerService.findAll().subscribe(next => {
    //   this.customerList = next;
    //   console.log(this.customerFather);
    // })
  }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:3000/service').subscribe((result: Service[]) => {
      this.serviceList = result;
      console.log(this.serviceList);
    })
  }

  showDetail(service: Service) {
    this.serviceFather = service;
  }

  showDetail2(service: Service) {
    this.serviceFather = service;
  }

  Search() {
    if (this.searchValue == "") {
      this.ngOnInit();
    } else {
      this.serviceList = this.serviceList.filter(res => {
        return res.serviceName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()) ||
          res.serviceCode.toLocaleLowerCase().match(this.searchValue.toLocaleLowerCase());
      })
    }
  }

  key: string = 'customerCode';
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
