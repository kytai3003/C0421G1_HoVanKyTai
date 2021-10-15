import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from "./app.component";
import {BusListComponent} from "./bus-list/bus-list.component";
import {BusEditComponent} from "./bus-edit/bus-edit.component";
import {BusCreateComponent} from "./bus-create/bus-create.component";


const routes: Routes = [
  {path: "", component: AppComponent},
  {path: "bus", component: BusListComponent},
  {path: "bus-edit/:id", component: BusEditComponent},
  {path: "bus-create", component: BusCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
