import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../../../models/customer/Customer";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  @Input("customerChild") customerDetail: Customer;

  constructor() { }

  ngOnInit(): void {
  }

}
