import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../../models/customer/Customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private api_url_customer = "http://localhost:3000/customer";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.api_url_customer);
  }

  createCustomer(customer: Customer):Observable<Customer> {
    return this.httpClient.post<Customer>(this.api_url_customer, customer);
  }

  findById(id: number) : Observable<Customer> {
    return this.httpClient.get<Customer>(this.api_url_customer + "?id=" + id);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.api_url_customer + "/" + id, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.httpClient.delete(`${this.api_url_customer}/${id}`);
  }
}
