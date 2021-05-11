import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { RouteData } from '../model/RouteData';
import { Station } from '../model/Station';
import { BusbookingService } from '../services/busbooking.service';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-routedetail',
  templateUrl: './routedetail.component.html',
  styleUrls: ['./routedetail.component.css']
})
export class RoutedetailComponent implements OnInit {

  //declared variables
  from: string = "";
  to: string = "";
  date: Date = new Date();
  today: any;
  maxDay: any;
  dateLimit = new Date;
  myControl = new FormControl();
  stations: Station[];
  cities: string[] = ['Pune', 'Mumbai'];

  //constructor
  constructor(private busBookingService: BusbookingService, private datepipe: DatePipe, private routeService: RouteService) {
    let todayDate = new Date();
    this.dateLimit.setDate(new Date().getDate() + 15);
    this.today = this.datepipe.transform(todayDate, 'yyyy-MM-dd');
    this.maxDay = this.datepipe.transform(this.dateLimit, 'yyyy-MM-dd');
    this.getAllStations();
  }

  ngOnInit(): void {
  }

  //method to search the bus using route details
  searchBus() {
    let selectedData = new RouteData(this.from, this.to, this.date);
    this.busBookingService.selected = selectedData;
  }

  //method to get station stored in the database
  getAllStations() {
    this.routeService.getAllRoute().subscribe(
      data => this.stations = data,
      error => console.log(error));
  }
}