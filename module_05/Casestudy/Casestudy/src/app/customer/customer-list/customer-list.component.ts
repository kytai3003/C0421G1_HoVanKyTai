import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../models/customer/Customer";
import {CustomerType} from "../../../models/customer/CustomerType";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerTypeList: CustomerType[] = [
    {typeId: 1, typeName: "Diamond"},
    {typeId: 2, typeName: "Platinum"},
    {typeId: 3, typeName: "Gold"},
    {typeId: 4, typeName: "Silver"},
    {typeId: 5, typeName: "Member"},
  ];

  customerList: Customer[] = [
    {
      customerId: 1,
      customerCode: "KH-0001",
      customerDob: "20-12-1992",
      customerName: "Nguyen Van A",
      customerIdCard: "123456789",
      customerPhone: "0909090909",
      customerEmail: "abc@gmail.com",
      customerAddress: "Da Nang",
      customerType: this.customerTypeList[0]
    },
    {
      customerId: 2,
      customerCode: "KH-0002",
      customerDob: "20-12-1993",
      customerName: "Nguyen Van B",
      customerIdCard: "123456789",
      customerPhone: "0909090909",
      customerEmail: "abc@gmail.com",
      customerAddress: "Da Nang",
      customerType: this.customerTypeList[2]
    },
    {
      customerId: 3,
      customerCode: "KH-0003",
      customerDob: "20-12-1994",
      customerName: "Nguyen Van C",
      customerIdCard: "123456789",
      customerPhone: "0909090909",
      customerEmail: "abc@gmail.com",
      customerAddress: "Da Nang",
      customerType: this.customerTypeList[3]
    },
    {
      customerId: 4,
      customerCode: "KH-0004",
      customerDob: "20-12-1995",
      customerName: "Nguyen Van E",
      customerIdCard: "123456789",
      customerPhone: "0909090909",
      customerEmail: "abc@gmail.com",
      customerAddress: "Da Nang",
      customerType: this.customerTypeList[1]
    },
    {
      customerId: 5,
      customerCode: "KH-0005",
      customerDob: "20-12-1999",
      customerName: "Nguyen Van F",
      customerIdCard: "123456789",
      customerPhone: "0909090909",
      customerEmail: "abc@gmail.com",
      customerAddress: "Da Nang",
      customerType: this.customerTypeList[4]
    },
  ];

  form = new FormGroup({
    customerId: new FormControl(''),
    customerCode: new FormControl(''),
    customerDob: new FormControl(''),
    customerName: new FormControl(''),
    customerIdCard: new FormControl(''),
    customerPhone: new FormControl(''),
    customerEmail: new FormControl(''),
    customerAddress: new FormControl(''),
    customerType: new FormControl(''),
  })

  customerFather: Customer;

  constructor() {
  }

  ngOnInit(): void {
  }


  showDetail(customer: Customer) {
    this.customerFather = customer;
  }
}
