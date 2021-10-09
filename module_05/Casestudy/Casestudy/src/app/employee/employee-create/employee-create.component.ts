import { Component, OnInit } from '@angular/core';
import {Employee} from "../../../models/employee/Employee";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Division} from "../../../models/employee/Division";
import {Position} from "../../../models/employee/Position";
import {Education} from "../../../models/employee/Education";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {EmployeeServiceService} from "../../service/employee-service.service";
import {DivisionService} from "../../service/division.service";
import {PositionService} from "../../service/position.service";
import {EducationService} from "../../service/education.service";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  employee: Employee;
  employeeForm: FormGroup;
  divisionList: Division[];
  positionList: Position[];
  educationList: Education[];
  constructor(private router: Router,
              private httpClient: HttpClient,
              private activatedRoute: ActivatedRoute,
              private snackBar: MatSnackBar,
              private employeeService: EmployeeServiceService,
              private divisionService: DivisionService,
              private positionService: PositionService,
              private educationService: EducationService) {
    this.employeeForm = new FormGroup({
      employeeCode: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^NV-\\d{4}$')])),
      employeeDob: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      employeeName: new FormControl("", Validators.required),
      employeeIdCard: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
      employeeSalary: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
      employeePhone: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
      employeeEmail: new FormControl("", Validators.compose([Validators.required, Validators.email])),
      employeeAddress: new FormControl("", Validators.required),
      employeePosition: new FormControl("", Validators.required),
      employeeDivision: new FormControl("", Validators.required),
      employeeEducation: new FormControl("", Validators.required),
    })
  }

  ngOnInit(): void {
    this.getType();
  }

  validationMessage = {
    employeeCode: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    employeeDob: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    employeeName: [
      {type: 'required', message: '<= Please input.'},
    ],
    employeeIdCard: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    employeeSalary: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Invalid number.'},
    ],
    employeePhone: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    employeeEmail: [
      {type: 'required', message: '<= Please input.'},
      {type: 'email', message: '<= Wrong format.'},
    ],
    employeeAddress: [
      {type: 'required', message: '<= Please input.'},
    ],
    employeePosition: [
      {type: 'required', message: '<= Please input.'},
    ],
    employeeDivision: [
      {type: 'required', message: '<= Please input.'},
    ],
    employeeEducation: [
      {type: 'required', message: '<= Please input.'},
    ]
  };

  getType() {
    this.positionService.findAll().subscribe(data1 => {
      this.positionList = data1;
    });
    this.divisionService.findAll().subscribe(data2 => {
      this.divisionList = data2;
    });
    this.educationService.findAll().subscribe(data3 => {
      this.educationList = data3;
    })
  };

  createEmployee() {
    if (this.employeeForm.valid) {

      this.employeeService.createEmployee(this.employeeForm.value).subscribe(next => {
        this.snackBar.open("New employee created.", "Close", {
          duration: 3000,
          verticalPosition: 'top',
          panelClass: 'blue-snackbar'
        } )
      });
      this.router.navigateByUrl("/employee");
    }
  }
}
