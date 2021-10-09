import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Employee} from "../../../models/employee/Employee";
import {EmployeeServiceService} from "../../service/employee-service.service";

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  id: number;
  employeeDelete: Employee;

  constructor(private employeeService: EmployeeServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private matSnackBar: MatSnackBar) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      this.getEmployee(this.id);
    })
  }

  ngOnInit(): void {
  }

  getEmployee(id: number) {
    return this.employeeService.findById(id).subscribe(customer => {
      this.employeeDelete = customer[0];
    });
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(() => {
      this.router.navigate(['/employee']);
      this.matSnackBar.open("Employee name: " + this.employeeDelete.employeeName + " deleted.", "OK", {
        duration: 3500,
        panelClass: "red-snackbar",
        verticalPosition: 'top'
      })
    }, e => {
      console.log(e);
    });
  }

}
