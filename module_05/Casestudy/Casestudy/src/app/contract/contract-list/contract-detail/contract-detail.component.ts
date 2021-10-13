import {Component, Input, OnInit} from '@angular/core';
import {Contract} from "../../../../models/contract/Contract";

@Component({
  selector: 'app-contract-detail',
  templateUrl: './contract-detail.component.html',
  styleUrls: ['./contract-detail.component.css']
})
export class ContractDetailComponent implements OnInit {
  @Input("contractChild") contractDetail: Contract;

  constructor() { }

  ngOnInit(): void {
  }

}
