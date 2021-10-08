import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../models/customer/Customer";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerServiceService} from "../../service/customer-service.service";
import {MatDialog} from "@angular/material/dialog";
import {CustomerDeleteComponent} from "./customer-delete/customer-delete.component";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

   p: number = 1;

   customerList: Customer[];

  form = new FormGroup({
    id: new FormControl(''),
    code: new FormControl(''),
    dob: new FormControl(''),
    name: new FormControl(''),
    idCard: new FormControl(''),
    phone: new FormControl(''),
    email: new FormControl(''),
    address: new FormControl(''),
    type: new FormControl(''),
  });

  customerFather: Customer;

  constructor(private router: Router, private customerService: CustomerServiceService, private dialog: MatDialog) {
    this.customerService.findAll().subscribe(next => {
      this.customerList = next;
      console.log(this.customerFather);
    })
  }

  ngOnInit(): void {
  }


  showDetail(customer: Customer) {
    this.customerFather = customer;
  }

  openModal(id: number) {
    console.log(id);
    this.customerService.findById(id).subscribe(dataDialog => {
      console.log(dataDialog);
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {name: dataDialog},
        disableClose: true
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
