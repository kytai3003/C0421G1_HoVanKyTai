import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Contract} from "../../../models/contract/Contract";
import {ContractService} from "../../service/contract.service";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  p: number = 1;

  contractList: Contract[];

  constructor(private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient,
              private contractService: ContractService) { }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:3000/contract').subscribe((result: Contract[]) => {
      this.contractList = result;
      console.log(this.contractList);
    })
  }

  contractFather: Contract;
  searchValue: string;

  showDetail(contract: Contract) {
    this.contractFather = contract;
  }

  Search() {
    if (this.searchValue == "") {
      this.ngOnInit();
    } else {
      this.contractList = this.contractList.filter(res => {
        return res.dateStart.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()) ||
          res.customer.customerName.toLocaleLowerCase().match(this.searchValue.toLocaleLowerCase());
      })
    }
  }

  key: string = 'dateStart';
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
