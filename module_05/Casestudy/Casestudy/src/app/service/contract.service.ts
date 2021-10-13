import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Contract} from "../../models/contract/Contract";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  private api_url_contract = "http://localhost:3000/contract";

  constructor(private httpClient: HttpClient) { }

  findAll() :Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.api_url_contract);
  }

  createContract(contract: Contract):Observable<Contract> {
    return this.httpClient.post<Contract>(this.api_url_contract, contract);
  }

  findById(id: number) : Observable<Contract> {
    return this.httpClient.get<Contract>(this.api_url_contract + "?id=" + id);
  }

  updateContract(id: number, contract: Contract): Observable<Contract> {
    return this.httpClient.put<Contract>(this.api_url_contract + "/" + id, contract);
  }

  deleteContract(id: number): Observable<any> {
    return this.httpClient.delete(this.api_url_contract+ "/" + id);
  }
}
