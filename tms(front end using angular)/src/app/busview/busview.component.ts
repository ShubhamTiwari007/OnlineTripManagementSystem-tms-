import { Component, OnInit } from '@angular/core';
import { RouteData } from '../model/RouteData';
import { BusbookingService } from '../services/busbooking.service';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-busview',
  templateUrl: './busview.component.html',
  styleUrls: ['./busview.component.css']
})
export class BusviewComponent implements OnInit {

  //declared variables 
  routeData:RouteData;
  from: string;
  to: string;
  date: Date;
  mydata: any = "";
  Buses: any;

  //constructor
  constructor(private busBookingService: BusbookingService, private routeService: RouteService) { 
    let selectedData = this.busBookingService.selected;
    this.from = selectedData.from;
    this.to = selectedData.to;
    this.date = selectedData.date;
    this.getRoute(this.from, this.to);
  }

  ngOnInit(): void {
  }

  //method to get route data by using station name
  getRoute(from:string, to:string) {
    this.routeService.getRoute(from, to).subscribe(
      data => {
        this.mydata = data;
      }
    ), 
      (error: any) => {
      console.log(error);
    }
  }

  onBooking(id:number) {
    this.busBookingService.busSelected = id;
  }
}


