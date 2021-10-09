import { Component, OnInit } from '@angular/core';
import {Employee} from "../../../models/employee/Employee";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {EmployeeServiceService} from "../../service/employee-service.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  p: number = 1;

  employeeList: Employee[];

  constructor(private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient,
              private employeeService: EmployeeServiceService) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:3000/employee').subscribe((result: Employee[]) => {
      this.employeeList = result;
      console.log(this.employeeList);
    })
  }

  employeeFather: Employee;
  searchValue: string;

  showDetail(employee: Employee) {
    this.employeeFather = employee;
  }

  Search() {
    if (this.searchValue == "") {
      this.ngOnInit();
    } else {
      this.employeeList = this.employeeList.filter(res => {
        return res.employeeName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()) ||
          res.employeeCode.toLocaleLowerCase().match(this.searchValue.toLocaleLowerCase());
      })
    }
  }

  key: string = 'employeeCode';
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
