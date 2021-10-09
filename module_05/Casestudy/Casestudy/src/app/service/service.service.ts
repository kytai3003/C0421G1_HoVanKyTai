import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Service} from "../../models/service/Service";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private api_url_service = "http://localhost:3000/service";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Service[]> {
    return this.httpClient.get<Service[]>(this.api_url_service);
  }

  createService(service: Service):Observable<Service> {
    return this.httpClient.post<Service>(this.api_url_service, service);
  }

  findById(id: number) : Observable<Service> {
    return this.httpClient.get<Service>(this.api_url_service + "?id=" + id);
  }

  updateService(id: number, service: Service): Observable<Service> {
    return this.httpClient.put<Service>(this.api_url_service + "/" + id, service);
  }

  deleteService(id: number): Observable<any> {
    return this.httpClient.delete(this.api_url_service+ "/" + id);
  }
}
