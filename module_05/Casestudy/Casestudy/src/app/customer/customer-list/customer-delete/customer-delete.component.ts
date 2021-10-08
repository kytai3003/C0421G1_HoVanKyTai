import {Component, Inject, Input, OnInit} from '@angular/core';
import {Customer} from "../../../../models/customer/Customer";
import {CustomerServiceService} from "../../../service/customer-service.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  id: number;
  name: string;

  constructor(private customerService: CustomerServiceService,
              private dialogRef: MatDialogRef<CustomerDeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.name = this.data.name.customerName;
    this.id = this.data.name.id;
    console.log(this.name, this.id);
  };


  deleteCustomer() {
    this.customerService.deleteCustomer(this.id).subscribe(dataDialog => {
      this.dialogRef.close();
    });
  }
}
