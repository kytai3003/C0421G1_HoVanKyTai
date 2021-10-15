import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bus} from "../model/Bus";

@Injectable({
  providedIn: 'root'
})
export class BusService {

  private api_url_bus = "http://localhost:8080/bus/api";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Bus[]> {
    return this.httpClient.get<Bus[]>(this.api_url_bus);
  }

  createBus(bus: Bus):Observable<Bus> {
    return this.httpClient.post<Bus>(this.api_url_bus + "/create/", JSON.stringify(bus));
  }

  findById(id: number) : Observable<Bus> {
    return this.httpClient.get<Bus>(this.api_url_bus + "/detail/" + id);
  }

  updateBus(id: number, bus: Bus): Observable<Bus> {
    return this.httpClient.put<Bus>(this.api_url_bus + "/edit/" + id, JSON.stringify(bus));
  }

  deleteBus(id: number): Observable<any> {
    return this.httpClient.delete(this.api_url_bus+ "/delete/" + id);
  }
}
