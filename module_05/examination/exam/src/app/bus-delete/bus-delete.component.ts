import {Component, Input, OnInit} from '@angular/core';
import {Bus} from "../model/Bus";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {BusService} from "../service/bus.service";

@Component({
  selector: 'app-bus-delete',
  templateUrl: './bus-delete.component.html',
  styleUrls: ['./bus-delete.component.css']
})
export class BusDeleteComponent implements OnInit {

  @Input("busChild") busDelete: Bus;
  id: number;

  constructor(private router: Router,
              private busService: BusService,
              private activatedRoute: ActivatedRoute,
              private matSnackBar: MatSnackBar) {

  }

  ngOnInit(): void {
  }

  // getService() {
  //   return this.serviceService.findById(this.serviceDelete.id).subscribe(service => {
  //     this.serviceDelete = service[0];
  //     console.log(this.serviceDelete.id)
  //   });
  // }

  deleteService() {
    this.busService.deleteBus(this.busDelete.id).subscribe(() => {
      this.redirectTo('/bus')
      this.matSnackBar.open("Bus code: " + this.busDelete.busCode + " deleted.", null, {
        duration: 3500,
        panelClass: "red-snackbar",
        verticalPosition: 'top'
      })
    }, e => {
    });
  }

  redirectTo(uri:string){
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate([uri]));
  }
}
