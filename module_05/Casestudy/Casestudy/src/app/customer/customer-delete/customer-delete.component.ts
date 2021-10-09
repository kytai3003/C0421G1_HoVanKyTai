import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from "../../service/customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Customer} from "../../../models/customer/Customer";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {


  id: number;
  customerDelete: Customer;

  constructor(private customerService: CustomerServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private matSnackBar: MatSnackBar) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      this.getCustomer(this.id);
    })
  }

  ngOnInit(): void {
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.customerDelete = customer[0];
    });
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(() => {
      this.router.navigate(['/customer']);
      this.matSnackBar.open("Customer name: " + this.customerDelete.customerName + " deleted.", "OK", {
        duration: 3500,
        panelClass: "red-snackbar",
        verticalPosition: 'top'
      })
    }, e => {
      console.log(e);
    });
  }
}
