import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Position} from "../../models/employee/Position";

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  private api_url_position = "http://localhost:3000/position";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Position[]> {
    return this.httpClient.get<Position[]>(this.api_url_position);
  }
}
