import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../../models/employee/Employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private api_url_employee = "http://localhost:3000/employee";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.api_url_employee);
  }

  createEmployee(employee: Employee):Observable<Employee> {
    return this.httpClient.post<Employee>(this.api_url_employee, employee);
  }

  findById(id: number) : Observable<Employee> {
    return this.httpClient.get<Employee>(this.api_url_employee + "?id=" + id);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(this.api_url_employee + "/" + id, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete(this.api_url_employee+ "/" + id);
  }
}
