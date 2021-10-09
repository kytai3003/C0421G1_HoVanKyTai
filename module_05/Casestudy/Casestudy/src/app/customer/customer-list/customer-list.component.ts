import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../models/customer/Customer";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerServiceService} from "../../service/customer-service.service";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  p: number = 1;

  customerList: Customer[];

  form = new FormGroup({
    id: new FormControl(''),
    code: new FormControl(''),
    dob: new FormControl(''),
    name: new FormControl(''),
    idCard: new FormControl(''),
    phone: new FormControl(''),
    email: new FormControl(''),
    address: new FormControl(''),
    type: new FormControl(''),
  });

  customerFather: Customer;
  searchValue: string;

  constructor(private router: Router,
              private customerService: CustomerServiceService,
              private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient,
              private snackBar: MatSnackBar) {
    // this.customerService.findAll().subscribe(next => {
    //   this.customerList = next;
    //   console.log(this.customerFather);
    // })
  }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:3000/customer').subscribe((result: Customer[]) => {
      this.customerList = result;
      console.log(this.customerList);
    })
  }

  showDetail(customer: Customer) {
    this.customerFather = customer;
  }

  Search() {
    if (this.searchValue == "") {
      this.ngOnInit();
    } else {
      this.customerList = this.customerList.filter(res => {
        return res.customerName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()) ||
          res.customerCode.toLocaleLowerCase().match(this.searchValue.toLocaleLowerCase());
      })
    }
  }

  key: string = 'customerCode';
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
