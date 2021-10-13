import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Service} from "../../../models/service/Service";
import {ServiceType} from "../../../models/service/service-type";
import {ServiceService} from "../../service/service.service";
import {ServiceTypeService} from "../../service/service-type.service";

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {

  service: Service;
  serviceForm: FormGroup;
  serviceTypeList: ServiceType[];

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private serviceService: ServiceService,
              private serviceTypeService: ServiceTypeService,
              private snackBar: MatSnackBar) {
    this.serviceForm = new FormGroup({
        serviceCode: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^DV-\\d{4}$')])),
        serviceName: new FormControl("", Validators.required),
        serviceArea: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
        serviceFloor: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
        serviceCapacity: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
        serviceCost: new FormControl("", Validators.compose([Validators.required, Validators.min(0)])),
        serviceStatus: new FormControl("", Validators.required),
        serviceType: new FormControl("", Validators.required),
      }
    )
  };

  validationMessage = {
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


  ngOnInit(): void {
    this.getType();
  }

  getType() {
    this.serviceTypeService.findAll().subscribe(data => {
      this.serviceTypeList = data;
    })
  }


  createService() {
    if (this.serviceForm.valid) {
      this.serviceService.createService(this.serviceForm.value).subscribe(next => {
        this.snackBar.open("New service created.", null, {
          duration: 2000,
          verticalPosition: 'top',
          panelClass: 'blue-snackbar'
        } )
      });
    }
    this.router.navigateByUrl("/service");
  }

}
