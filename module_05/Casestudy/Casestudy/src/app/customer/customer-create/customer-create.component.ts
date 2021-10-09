import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../service/customer-service.service";
import {Customer} from "../../../models/customer/Customer";
import {CustomerTypeServiceService} from "../../service/customer-type-service.service";
import {CustomerType} from "../../../models/customer/CustomerType";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customer: Customer;
  customerForm: FormGroup;
  customerType: CustomerType[];

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private customerService: CustomerServiceService,
              private customerTypeList: CustomerTypeServiceService,
              private snackBar: MatSnackBar) {
    this.customerForm = new FormGroup({
      customerCode: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^KH-\\d{4}$')])),
      customerDob: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      customerName: new FormControl("", Validators.required),
      customerIdCard: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
      customerPhone: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
      customerEmail: new FormControl("", Validators.compose([Validators.required, Validators.email])),
      customerAddress: new FormControl("", Validators.required),
      customerType: new FormControl("", Validators.required),
      }
    )
  };

  validationMessage = {
    customerCode: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    customerDob: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    customerName: [
      {type: 'required', message: '<= Please input.'},
    ],
    customerIdCard: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    customerPhone: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    customerEmail: [
      {type: 'required', message: '<= Please input.'},
      {type: 'email', message: '<= Wrong format.'},
    ],
    customerAddress: [
      {type: 'required', message: '<= Please input.'},
    ],
    customerType: [
      {type: 'required', message: '<= Please input.'},
    ]
  };


  ngOnInit(): void {
    this.getType();
  }

  getType() {
    this.customerTypeList.findAll().subscribe(data => {
      this.customerType = data;
    })
  }


  createCustomer() {
    if (this.customerForm.valid) {
      this.customerService.createCustomer(this.customerForm.value).subscribe(next => {
        this.snackBar.open("New customer created.", "Close", {
          duration: 3000,
          verticalPosition: 'top',
          panelClass: 'blue-snackbar'
        } )
      });
        this.router.navigateByUrl("/customer");
    }
  }
}
