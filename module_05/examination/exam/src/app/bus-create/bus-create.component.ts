import { Component, OnInit } from '@angular/core';
import {Destination} from "../model/Destination";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {Bus} from "../model/Bus";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {BusService} from "../service/bus.service";
import {DestinationService} from "../service/destination.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-bus-create',
  templateUrl: './bus-create.component.html',
  styleUrls: ['./bus-create.component.css']
})
export class BusCreateComponent implements OnInit {

  id: number;
  destinationList: Destination[];
  busCreateForm: FormGroup;
  busCreate: Bus;

  constructor(private router: Router, private busService: BusService,
              private activatedRoute: ActivatedRoute,
              private destinationService: DestinationService,
              private matSnackBar: MatSnackBar) {
    this.busCreateForm = new FormGroup({
      busCode: new FormControl("", Validators.required),
      busType: new FormControl("", Validators.required),
      busName: new FormControl("", Validators.compose([Validators.required])),
      destinationFrom: new FormControl("", Validators.compose([Validators.required])),
      destinationTo: new FormControl("", Validators.compose([Validators.required])),
      busPhone: new FormControl("", Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|093\\d{7}|097\\d{7}$')])),
      busEmail: new FormControl("", Validators.compose([Validators.required,Validators.email])),
      hourFrom: new FormControl("", Validators.compose([Validators.required, this.checkDate])),
      hourTo: new FormControl("", Validators.compose([Validators.required, this.checkDate])),
    });
    }


  ngOnInit(): void {
    this.getType();
  }

  checkDate(abstractControl: AbstractControl): any {
    const hour = abstractControl.value;
    const legalHour1 = "23:00";
    const legalHour2 = "05:00";
    console.log(hour);

    return hour >= legalHour2 && hour <= legalHour1  ? null : {checkDate: true};
    // if (hour != "11:00 PM" || hour != "12:00 PM" || hour != "00:00 AM" || hour != "01:00 AM" || hour != "02:00 AM" || hour != "03:00 AM"|| hour != "04:00 AM") {
    //   return {checkDate: true};
    // } else {
    //   return null
    // }
  };


  validationMessage = {
    busCode: [
      {type: 'required', message: '<= Please input.'},
    ],
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
      {type: 'checkDate', message: '<= Time must be between 05:00 and 23:00'},
    ],
    hourTo: [
      {type: 'required', message: '<= Please input.'},
      {type: 'checkDate', message: '<= Time must be between 05:00 and 23:00'},
    ]
  };

  getType() {
    this.destinationService.findAll().subscribe(data => {
      this.destinationList = data;
    });
  }

  createBus() {
    if (this.busCreateForm.valid) {
      this.busService.createBus(this.busCreateForm.value).subscribe(next => {
        this.matSnackBar.open("New bus created.", null, {
          duration: 2000,
          verticalPosition: 'top',
          panelClass: 'blue-snackbar'
        } )
      });
      this.router.navigateByUrl("/bus");
    }
  }
}
