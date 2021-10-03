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
import { ServiceListComponent } from './service/service-list/service-list.component';
import { ServiceCreateComponent } from './service/service-create/service-create.component';
import { ServiceEditComponent } from './service/service-edit/service-edit.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractEditComponent } from './contract/contract-edit/contract-edit.component';
import { ContractDetailCreateComponent } from './contract/contract-detail-create/contract-detail-create.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceEditComponent,
    ContractListComponent,
    ContractCreateComponent,
    ContractEditComponent,
    ContractDetailCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
