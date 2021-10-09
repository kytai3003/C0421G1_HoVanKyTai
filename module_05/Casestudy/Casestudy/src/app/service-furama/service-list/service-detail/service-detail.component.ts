import {Component, Input, OnInit} from '@angular/core';
import {Service} from "../../../../models/service/Service";

@Component({
  selector: 'app-service-detail',
  templateUrl: './service-detail.component.html',
  styleUrls: ['./service-detail.component.css']
})
export class ServiceDetailComponent implements OnInit {

  @Input("serviceChild") serviceDetail: Service;
  constructor() { }

  ngOnInit(): void {
  }

}
