import { Component, OnInit } from '@angular/core';
import {Position} from "../../../models/employee/Position";
import {Education} from "../../../models/employee/Education";
import {Division} from "../../../models/employee/Division";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../../../models/employee/Employee";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {EmployeeServiceService} from "../../service/employee-service.service";
import {PositionService} from "../../service/position.service";
import {EducationService} from "../../service/education.service";
import {DivisionService} from "../../service/division.service";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  id: number;
  positionList: Position[];
  educationList: Education[];
  divisionList: Division[];

  employeeEditForm: FormGroup;
  employeeEdit: Employee;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private matSnackBar: MatSnackBar,
              private employeeService: EmployeeServiceService,
              private positionService: PositionService,
              private educationService: EducationService,
              private divisionService: DivisionService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getEmployee(this.id);
    })
  }

  ngOnInit(): void {
    this.getType();
  }

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

  getEmployee(id: number) {
    return this.employeeService.findById(id).subscribe(employee => {
      this.employeeEditForm = new FormGroup({
        id: new FormControl(employee.id),
        employeeCode: new FormControl(employee.employeeCode),
        employeeDob: new FormControl(employee.employeeDob, Validators.compose([Validators.required])),
        employeeName: new FormControl(employee.employeeName, Validators.required),
        employeeIdCard: new FormControl(employee.employeeIdCard, Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
        employeeSalary: new FormControl(employee.employeeSalary, Validators.compose([Validators.required, Validators.min(0)])),
        employeePhone: new FormControl(employee.employeePhone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
        employeeEmail: new FormControl(employee.employeeEmail, Validators.compose([Validators.required, Validators.email])),
        employeeAddress: new FormControl(employee.employeeAddress, Validators.required),
        employeePosition: new FormControl(employee.employeePosition, Validators.required),
        employeeDivision: new FormControl(employee.employeeDivision, Validators.required),
        employeeEducation: new FormControl(employee.employeeEducation, Validators.required),
      });
      this.employeeEdit = employee[0];
      this.employeeEditForm.patchValue(this.employeeEdit);
      console.log(employee);
    })
  };

  validationMessageEdit = {
    employeeCode: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    employeeDob: [
      {type: 'required', message: '<= Please input.'},
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

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  updateEmployee(id: number) {
    const employee = this.employeeEditForm.value;
    this.employeeService.updateEmployee(id, employee).subscribe(() => {
      this.matSnackBar.open("Employee code: " + this.employeeEdit.employeeCode + " edited.", "", {
        duration: 3000,
        verticalPosition: 'top',
        panelClass: 'green-snackbar'
      } )
    });
    this.router.navigateByUrl("/employee");
  }
}
