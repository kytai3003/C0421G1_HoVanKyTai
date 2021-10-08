import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractEditComponent } from './contract/contract-edit/contract-edit.component';
import { ContractDetailCreateComponent } from './contract/contract-detail-create/contract-detail-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerDetailComponent } from './customer/customer-list/customer-detail/customer-detail.component';
import { HomeComponent } from './home/home.component';
import {NgxPaginationModule} from "ngx-pagination";
import {HttpClientModule} from "@angular/common/http";
import { CustomerDeleteComponent } from './customer/customer-list/customer-delete/customer-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
    ContractListComponent,
    ContractCreateComponent,
    ContractEditComponent,
    ContractDetailCreateComponent,
    CustomerDetailComponent,
    HomeComponent,
    CustomerDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
