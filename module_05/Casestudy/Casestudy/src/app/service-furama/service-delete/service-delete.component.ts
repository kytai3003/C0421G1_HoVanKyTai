import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Service} from "../../../models/service/Service";
import {ServiceService} from "../../service/service.service";

@Component({
  selector: 'app-service-delete',
  templateUrl: './service-delete.component.html',
  styleUrls: ['./service-delete.component.css']
})
export class ServiceDeleteComponent implements OnInit {


  @Input("serviceChild2") serviceDelete: Service;
  id: number;

  constructor(private serviceService: ServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private matSnackBar: MatSnackBar) {
    // this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    //   this.id = +paramMap.get("id");
    //   this.getService(this.id);
    // })
  }

  ngOnInit(): void {
    // this.getService();
  }

  getService() {
    return this.serviceService.findById(this.serviceDelete.id).subscribe(service => {
      this.serviceDelete = service[0];
      console.log(this.serviceDelete.id)
    });
  }

  deleteService() {
    this.serviceService.deleteService(this.serviceDelete.id).subscribe(() => {
      this.redirectTo('/service')
      this.matSnackBar.open("Service code: " + this.serviceDelete.serviceCode + " deleted.", null, {
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
