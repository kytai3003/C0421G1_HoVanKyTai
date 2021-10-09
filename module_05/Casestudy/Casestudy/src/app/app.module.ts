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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CustomerDetailComponent } from './customer/customer-list/customer-detail/customer-detail.component';
import { HomeComponent } from './home/home.component';
import {NgxPaginationModule} from "ngx-pagination";
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from "@angular/material/dialog";
import {CustomerDeleteComponent} from "./customer/customer-delete/customer-delete.component";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {Ng2OrderModule} from "ng2-order-pipe";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { EmployeeDetailComponent } from './employee/employee-list/employee-detail/employee-detail.component';
import { EmployeeDeleteComponent } from './employee/employee-delete/employee-delete.component';
import { ServiceListComponent } from './service-furama/service-list/service-list.component';
import { ServiceCreateComponent } from './service-furama/service-create/service-create.component';
import { ServiceEditComponent } from './service-furama/service-edit/service-edit.component';
import { ServiceDeleteComponent } from './service-furama/service-delete/service-delete.component';
import { ServiceDetailComponent } from './service-furama/service-list/service-detail/service-detail.component';


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
    CustomerDeleteComponent,
    EmployeeDetailComponent,
    EmployeeDeleteComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceEditComponent,
    ServiceDeleteComponent,
    ServiceDetailComponent,
  ],
  imports: [
    BrowserModule,
    MatDialogModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
