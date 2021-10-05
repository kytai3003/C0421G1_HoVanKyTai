import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../models/Customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerList: Customer[] = [
    {customerId: 1, customerCode: "KH-0001", customerDob: "20-12-1992", customerName: "Nguyen Van A", customerIdCard: "123456789", customerPhone: "0909090909", customerEmail: "abc@gmail.com", customerAddress: "Da Nang", customerTypeId: 1},
    {customerId: 2, customerCode: "KH-0002", customerDob: "20-12-1993", customerName: "Nguyen Van B", customerIdCard: "123456789", customerPhone: "0909090909", customerEmail: "abc@gmail.com", customerAddress: "Da Nang", customerTypeId: 2},
    {customerId: 3, customerCode: "KH-0003", customerDob: "20-12-1994", customerName: "Nguyen Van C", customerIdCard: "123456789", customerPhone: "0909090909", customerEmail: "abc@gmail.com", customerAddress: "Da Nang", customerTypeId: 3},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
