import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../service/customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerTypeServiceService} from "../../service/customer-type-service.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ServiceType} from "../../../models/service/service-type";
import {Service} from "../../../models/service/Service";
import {ServiceService} from "../../service/service.service";
import {ServiceTypeService} from "../../service/service-type.service";

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {

  id: number;
  serviceTypeList: ServiceType[];
  serviceEditForm: FormGroup;
  serviceEdit: Service;

  constructor(private router: Router, private serviceService: ServiceService,
              private activatedRoute: ActivatedRoute,
              private serviceTypeService: ServiceTypeService,
              private matSnackBar: MatSnackBar) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    })
  };

  ngOnInit(): void {
    this.getType();
  }

  getCustomer(id: number) {
    return this.serviceService.findById(id).subscribe(service => {
      this.serviceEditForm = new FormGroup({
        id: new FormControl(service.id),
        serviceCode: new FormControl(service.serviceCode),
        serviceName: new FormControl(service.serviceName, Validators.required),
        serviceArea: new FormControl(service.serviceArea, Validators.compose([Validators.required, Validators.min(0)])),
        serviceFloor: new FormControl(service.serviceFloor, Validators.compose([Validators.required, Validators.min(0)])),
        serviceCapacity: new FormControl(service.serviceCapacity, Validators.compose([Validators.required, Validators.min(0)])),
        serviceCost: new FormControl(service.serviceCost, Validators.compose([Validators.required, Validators.min(0)])),
        serviceStatus: new FormControl(service.serviceStatus, Validators.required),
        serviceType: new FormControl(service.serviceType, Validators.required),
      });
      this.serviceEdit = service[0];
      this.serviceEditForm.patchValue(this.serviceEdit);
      console.log(service);
    })
  };

  validationMessageEdit = {
    serviceCode: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format.'},
    ],
    serviceName: [
      {type: 'required', message: '<= Please input.'},
    ],
    serviceArea: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong input.'},
    ],
    serviceFloor: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong input.'},
    ],
    serviceCapacity: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong input.'},
    ],
    serviceCost: [
      {type: 'required', message: '<= Please input.'},
      {type: 'min', message: '<= Wrong input.'},
    ],
    serviceStatus: [
      {type: 'required', message: '<= Please input.'},
    ],
    serviceType: [
      {type: 'required', message: '<= Please input.'},
    ]
  };

  getType() {
    this.serviceTypeService.findAll().subscribe(data => {
      this.serviceTypeList = data;
    });
  }

  updateService(id: number) {
    const service = this.serviceEditForm.value;
    this.serviceService.updateService(id, service).subscribe(() => {
      this.matSnackBar.open("Service code: " + this.serviceEdit.serviceCode + " edited.", "", {
        duration: 3000,
        verticalPosition: 'top',
        panelClass: 'green-snackbar'
      } )
    });
    this.router.navigateByUrl("/service");
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
