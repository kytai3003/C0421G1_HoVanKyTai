import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormGroup, FormControl, Validators, AbstractControl} from "@angular/forms";
import {CustomerServiceService} from "../../service/customer-service.service";
import {Customer} from "../../../models/customer/Customer";
import {CustomerTypeServiceService} from "../../service/customer-type-service.service";
import {CustomerType} from "../../../models/customer/CustomerType";
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Service} from "../../../models/service/Service";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customer: Customer;
  customerForm: FormGroup;
  customerType: CustomerType[];
  customerList: Customer[] | undefined;
  customerCodeList: string[];


  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private customerService: CustomerServiceService,
              private customerTypeList: CustomerTypeServiceService,
              private snackBar: MatSnackBar,
              private httpClient: HttpClient) {
    this.customerForm = new FormGroup({
      customerCode: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^KH-\\d{4}$')])),
      customerDob: new FormControl("", Validators.compose([Validators.required])),
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
      {type: 'errorCode', message: '<= Duplicate code.'},
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
    // this.httpClient.get('http://localhost:3000/customer').subscribe((result: Customer[]) => {
    //   this.customerList = result;
    //   console.log(this.customerList);
    //   for (let i =0; i < this.customerList.length; i++) {
    //     // this.customerCodeList.unshift(this.customerList[i].customerCode);
    //     console.log(this.customerList[i].customerCode);
    //     this.customerCodeList[0] = this.customerList[i].customerCode;
    //     console.log(this.customerCodeList)
    //   }
    // })
  }

  getType() {
    this.customerTypeList.findAll().subscribe(data => {
      this.customerType = data;
    });
  };

  // checkDuplicate(abstractControl: AbstractControl): any {
  //   const inputCode = abstractControl.value;
  //   for (let i = 0; i < this.customerList.length; i++) {
  //     if (this.customerList[i].customerCode == inputCode) {
  //       return {errorCode: true};
  //     }
  //   }
  //   return null;
  // }


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
