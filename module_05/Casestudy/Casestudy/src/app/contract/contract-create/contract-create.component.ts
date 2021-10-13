import { Component, OnInit } from '@angular/core';
import {Employee} from "../../../models/employee/Employee";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {EmployeeServiceService} from "../../service/employee-service.service";
import {Contract} from "../../../models/contract/Contract";
import {Customer} from "../../../models/customer/Customer";
import {Service} from "../../../models/service/Service";
import {ContractService} from "../../service/contract.service";
import {CustomerServiceService} from "../../service/customer-service.service";
import {ServiceService} from "../../service/service.service";
@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {

  contract: Contract;
  contractForm: FormGroup;
  employeeList: Employee[];
  customerList: Customer[];
  serviceList: Service[];
  min: number =  Date.now();

  constructor(private router: Router,
              private httpClient: HttpClient,
              private activatedRoute: ActivatedRoute,
              private snackBar: MatSnackBar,
              private contractService: ContractService,
              private employeeService: EmployeeServiceService,
              private customerService: CustomerServiceService,
              private serviceService: ServiceService) {
    this.contractForm = new FormGroup({
      dateStart: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      dateEnd: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$'), this.checkDate])),
      deposit: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
      totalAmount: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
      employee: new FormControl("", Validators.required),
      customer: new FormControl("", Validators.required),
      service: new FormControl("", Validators.required)
    })
  }

  ngOnInit(): void {
    this.getType();
  }

  validationMessage = {
    dateStart: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    dateEnd: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
      {type: 'checkDate', message: '<= End date must be after start date.'},
    ],
    deposit: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong number.'},
    ],
    totalAmount: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong number.'},
    ],
    employee: [
      {type: 'required', message: '<= Please input.'},
    ],
    customer: [
      {type: 'required', message: '<= Please input.'},
    ],
    service: [
      {type: 'required', message: '<= Please input.'},
    ]
  };

  getType() {
    this.customerService.findAll().subscribe(data1 => {
      this.customerList = data1;
    });
    this.employeeService.findAll().subscribe(data2 => {
      this.employeeList = data2;
    });
    this.serviceService.findAll().subscribe(data3 => {
      this.serviceList = data3;
    })
  };

  createContract() {
    if (this.contractForm.valid) {

      this.contractService.createContract(this.contractForm.value).subscribe(next => {
        this.snackBar.open("New contract created.", "OK", {
          duration: 3000,
          verticalPosition: 'top',
          panelClass: 'blue-snackbar'
        } )
      });
      this.router.navigateByUrl("/contract");
    }
  }

  checkDate(abstractControl: AbstractControl): any {
    const start = abstractControl.value;
    const end = abstractControl.value;
    console.log(start);
    console.log(end);

    return start < end ? null : {checkDate: true};
  }
}
