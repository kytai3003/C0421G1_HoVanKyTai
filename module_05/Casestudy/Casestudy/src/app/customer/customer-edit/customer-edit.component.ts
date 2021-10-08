import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../models/customer/Customer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../service/customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerType} from "../../../models/customer/CustomerType";
import {CustomerTypeServiceService} from "../../service/customer-type-service.service";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  id: number;
  customerTypeList: CustomerType[];
  public customerEditForm: FormGroup;
  public customerEdit: Customer;

  constructor(private customerService: CustomerServiceService, private activatedRoute: ActivatedRoute,
              private customerType: CustomerTypeServiceService, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    })
  };

  ngOnInit(): void {
    this.getType();
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.customerEditForm = new FormGroup({
        id: new FormControl({value: customer.id, disabled: true}),
        customerCode: new FormControl(customer.customerCode, Validators.compose([Validators.required, Validators.pattern('^KH-\\d{4}$')])),
        customerDob: new FormControl(customer.customerDob, Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
        customerName: new FormControl(customer.customerName, Validators.required),
        customerIdCard: new FormControl(customer.customerIdCard, Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
        customerPhone: new FormControl(customer.customerPhone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
        customerEmail: new FormControl(customer.customerEmail, Validators.compose([Validators.required, Validators.email])),
        customerAddress: new FormControl(customer.customerAddress, Validators.required),
        customerType: new FormControl(customer.customerType, Validators.required)
    });
      this.customerEdit = customer[0];
      this.customerEditForm.patchValue(this.customerEdit);
      console.log(customer);
  })
  };

  validationMessageEdit = {
    customerCode: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    customerDob: [
      {type: 'required', message: '<- Please input.'},
      {type: 'pattern', message: '<- Wrong format.'}
    ],
    customerName: [
      {type: 'required', message: '<- Please input.'},
    ],
    customerIdCard: [
      {type: 'required', message: '<- Please input.'},
      {type: 'pattern', message: '<- Wrong format.'},
    ],
    customerPhone: [
      {type: 'required', message: '<- Please input.'},
      {type: 'pattern', message: '<- Wrong format.'},
    ],
    customerEmail: [
      {type: 'required', message: '<- Please input.'},
      {type: 'email', message: '<- Wrong format.'},
    ],
    customerAddress: [
      {type: 'required', message: '<- Please input.'},
    ],
    customerType: [
      {type: 'required', message: '<= Please input.'},
    ]
  };

  getType() {
    this.customerType.findAll().subscribe(data => {
      this.customerTypeList = data;
    });
  }

  updateCustomer(id: number) {
    const customer = this.customerEditForm.value;
    this.customerService.updateCustomer(id, customer).subscribe(() => {
      this.router.navigateByUrl("/customer");
    })
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
