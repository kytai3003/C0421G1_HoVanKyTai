import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ServiceType} from "../../models/service/service-type";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ServiceTypeService {

  private api_url_serviceType = "http://localhost:3000/serviceType";

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<ServiceType[]> {
    return this.httpClient.get<ServiceType[]>(this.api_url_serviceType);
  }
}
