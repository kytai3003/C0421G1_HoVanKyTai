import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bus} from "../model/Bus";

@Injectable({
  providedIn: 'root'
})
export class BusService {

  private api_url_bus = "http://localhost:3000/bus";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Bus[]> {
    return this.httpClient.get<Bus[]>(this.api_url_bus);
  }

  findById(id: number) : Observable<Bus> {
    return this.httpClient.get<Bus>(this.api_url_bus + "?id=" + id);
  }

  updateBus(id: number, service: Bus): Observable<Bus> {
    return this.httpClient.put<Bus>(this.api_url_bus + "/" + id, service);
  }

  deleteBus(id: number): Observable<any> {
    return this.httpClient.delete(this.api_url_bus+ "/" + id);
  }
}
