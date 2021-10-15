import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Destination} from "../model/Destination";

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  private api_url_destination = "http://localhost:8080/destination/api";

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Destination[]> {
    return this.httpClient.get<Destination[]>(this.api_url_destination);
  }
}
