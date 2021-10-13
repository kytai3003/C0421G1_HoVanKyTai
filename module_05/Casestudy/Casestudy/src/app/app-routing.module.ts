import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {HomeComponent} from "./home/home.component";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";
import {CustomerDeleteComponent} from "./customer/customer-delete/customer-delete.component";
import {EmployeeListComponent} from "./employee/employee-list/employee-list.component";
import {EmployeeCreateComponent} from "./employee/employee-create/employee-create.component";
import {EmployeeEditComponent} from "./employee/employee-edit/employee-edit.component";
import {EmployeeDeleteComponent} from "./employee/employee-delete/employee-delete.component";
import {ServiceListComponent} from "./service-furama/service-list/service-list.component";
import {ServiceCreateComponent} from "./service-furama/service-create/service-create.component";
import {ServiceEditComponent} from "./service-furama/service-edit/service-edit.component";
import {ServiceDeleteComponent} from "./service-furama/service-delete/service-delete.component";
import {ContractListComponent} from "./contract/contract-list/contract-list.component";
import {ContractCreateComponent} from "./contract/contract-create/contract-create.component";
import {ContractEditComponent} from "./contract/contract-edit/contract-edit.component";


const routes: Routes = [
  {path: "", pathMatch: 'full', component: HomeComponent},
  {path: "customer", component: CustomerListComponent},
  {path: "employee", component: EmployeeListComponent},
  {path: "service", component: ServiceListComponent},
  {path: "contract", component: ContractListComponent},
  {path: "customer-create", component: CustomerCreateComponent},
  {path: "employee-create", component: EmployeeCreateComponent},
  {path: "service-create", component: ServiceCreateComponent},
  {path: "contract-create", component: ContractCreateComponent},
  {path: "customer-edit/:id", component: CustomerEditComponent},
  {path: "employee-edit/:id", component: EmployeeEditComponent},
  {path: "service-edit/:id", component: ServiceEditComponent},
  {path: "contract-edit/:id", component: ContractEditComponent},
  {path: "customer-delete/:id", component: CustomerDeleteComponent},
  {path: "employee-delete/:id", component: EmployeeDeleteComponent},
  {path: "service-delete/:id", component: ServiceDeleteComponent},
  {path: "contract-delete/:id", component: ServiceDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
