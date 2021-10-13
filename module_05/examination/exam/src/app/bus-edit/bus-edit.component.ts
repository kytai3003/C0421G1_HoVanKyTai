import { Component, OnInit } from '@angular/core';
import {Destination} from "../model/Destination";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Bus} from "../model/Bus";
import {BusService} from "../service/bus.service";
import {DestinationService} from "../service/destination.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-bus-edit',
  templateUrl: './bus-edit.component.html',
  styleUrls: ['./bus-edit.component.css']
})
export class BusEditComponent implements OnInit {

  id: number;
  destinationList: Destination[];
  busEditForm: FormGroup;
  busEdit: Bus;

  constructor(private router: Router, private busService: BusService,
              private activatedRoute: ActivatedRoute,
              private destinationService: DestinationService,
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
    return this.busService.findById(id).subscribe(bus => {
      this.busEditForm = new FormGroup({
        id: new FormControl(bus.id),
        busCode: new FormControl(bus.busCode),
        busType: new FormControl(bus.busType, Validators.required),
        busName: new FormControl(bus.busName, Validators.compose([Validators.required])),
        destinationFrom: new FormControl(bus.destinationFrom, Validators.compose([Validators.required])),
        destinationTo: new FormControl(bus.destinationTo, Validators.compose([Validators.required])),
        busPhone: new FormControl(bus.busPhone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|093\\d{7}|097\\d{7}$')])),
        busEmail: new FormControl(bus.busEmail, Validators.compose([Validators.required,Validators.email])),
        hourFrom: new FormControl(bus.hourFrom, Validators.compose([Validators.required, this.checkDate])),
        hourTo: new FormControl(bus.hourTo, Validators.compose([Validators.required, this.checkDate])),
      });
      this.busEdit = bus[0];
      this.busEditForm.patchValue(this.busEdit);
      console.log(bus);
    })
  };

  checkDate(abstractControl: AbstractControl): any {
    const hour = abstractControl.value;
    const toNum = hour;
    const legalHour1 = 2300;
    const legalHour2 = 500;
    console.log(hour);
    console.log(toNum);

    return toNum > legalHour2 && toNum < legalHour1  ? null : {checkDate: true};
  };


  validationMessageEdit = {
    busType: [
      {type: 'required', message: '<= Please input.'},
    ],
    busName: [
      {type: 'required', message: '<= Please input.'},
    ],
    destinationFrom: [
      {type: 'required', message: '<= Please choose one.'},
    ],
    destinationTo: [
      {type: 'required', message: '<= Please choose one.'},
    ],
    busPhone: [
      {type: 'required', message: '<= Please input.'},
      {type: 'pattern', message: '<= Wrong format. Start with 090 or 093 or 097'},
    ],
    busEmail: [
      {type: 'required', message: '<= Please input.'},
      {type: 'email', message: '<= Wrong email format.'},
    ],
    hourFrom: [
      {type: 'required', message: '<= Please input.'},
      {type: 'checkDate', message: '<= Time must be between 5:00 and 23:00'},
    ],
    hourTo: [
      {type: 'required', message: '<= Please input.'},
      {type: 'checkDate', message: '<= Time must be between 5:00 and 23:00'},
    ]
  };

  getType() {
    this.destinationService.findAll().subscribe(data => {
      this.destinationList = data;
    });
  }

  updateBus(id: number) {
    const bus = this.busEditForm.value;
    this.busService.updateBus(id, bus).subscribe(() => {
      this.matSnackBar.open("Bus code: " + this.busEdit.busCode + " edited.", "", {
        duration: 3000,
        verticalPosition: 'top',
        panelClass: 'green-snackbar'
      } )
    });
    this.router.navigateByUrl("/bus");
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
