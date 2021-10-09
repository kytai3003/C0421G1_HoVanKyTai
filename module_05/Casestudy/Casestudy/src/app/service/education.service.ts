import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Education} from "../../models/employee/Education";

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  private api_url_education = "http://localhost:3000/education";
  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Education[]> {
    return this.httpClient.get<Education[]>(this.api_url_education);
  }
}
