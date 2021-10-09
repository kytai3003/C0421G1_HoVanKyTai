import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Division} from "../../models/employee/Division";

@Injectable({
  providedIn: 'root'
})
export class DivisionService {

  private api_url_division = "http://localhost:3000/division";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Division[]> {
    return this.httpClient.get<Division[]>(this.api_url_division);
  }
}
