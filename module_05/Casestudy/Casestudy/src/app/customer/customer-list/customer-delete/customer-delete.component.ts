import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../../../models/customer/Customer";
import {CustomerServiceService} from "../../../service/customer-service.service";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  customerDelete: Customer;
  id: number = this.customerDelete.id;
  name: string = this.customerDelete.customerName;

  constructor(private customerService: CustomerServiceService) { }

  ngOnInit(): void {
    console.log(this.customerDelete);
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.id);
  }
}
