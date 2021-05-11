import { Component, OnInit } from '@angular/core';
import { Bus } from '../model/Bus';
import { BusBooking } from '../model/BusBooking';
import { Customer } from '../model/Customer';
import { RouteData } from '../model/RouteData';
import { Station } from '../model/Station';
import { BusService } from '../services/bus.service';
import { BusbookingService } from '../services/busbooking.service';
import { CustomerService } from '../services/customer.service';
import { StationService } from '../services/station.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-busbookingview',
  templateUrl: './busbookingview.component.html',
  styleUrls: ['./busbookingview.component.css']
})
export class BusbookingviewComponent implements OnInit {

  //declared variables
  from_Station: Station;
  to_Station: Station;
  Bus: Bus;
  customer: Customer;
  from: any;
  to: any;
  date: any;
  noOfCustomer: any = 1;
  ticketfare = 0;
  rent = 600;
  jDate: string;

  //constructor
  constructor(private busService: BusService, private busBookingService: BusbookingService, private customerService: CustomerService, private stationService: StationService) {
    let routeData: RouteData = this.busBookingService.selected;
    this.from = routeData.from;
    this.to = routeData.to;
    this.date = routeData.date;
    this.jDate = routeData.date.toDateString();
    // this.jDate = routeData.date.toDateString();
    this.ticketfare = this.rent;
    this.getBusById(this.busBookingService.busSelected);
    this.getFromStationByName(this.from);
    this.getToStationByName(this.to);
    this.getCustomerById(26);
  }

  ngOnInit(): void {
  }

  //method to store the bus booking to database
  storeBusBooking() {
    let busBooking: BusBooking = new BusBooking(this.noOfCustomer, this.rent, new Date(), this.jDate, this.Bus.dep, this.Bus.arr, this.customer, this.from_Station, this.to_Station, this.Bus);
    console.log(busBooking);
    this.addBusBooking(busBooking);
  }

  //method to call the busBooking service and then store data to database 
  addBusBooking(busBooking:BusBooking) {
    this.busBookingService.addBusBooking(busBooking).subscribe(
      data => {
        console.log("Bus Booked..." + data);

        //sweet alsert box to confirm the booking
        Swal.fire({
          title: 'Completed',
          text: "Booking has been done",
          icon: 'success'
        });
      },
      error => {
        console.log(error);
      }
    )
  }

  //method to get bus data using bus id from the service 
  getBusById(id: number) {
    this.busService.getBusById(id).subscribe(data => {
      this.Bus = data;
    },
      error => {
        console.log(error + "Error Occured");
      }
    )
  }
  
  //method to get station data using station name from the service
  getToStationByName(name: string) {
    this.stationService.getStationByName(name).subscribe(
      data => {
        this.to_Station = data;
      }
    )
    return null;
  }

  //method to get station data using station name from the service
  getFromStationByName(name: string) {
    this.stationService.getStationByName(name).subscribe(
      data => this.from_Station = data,
      error => console.log(error));
  }

  //method to get customer data using custome id 
  getCustomerById(id: number) {
    this.customerService.getCustomerById(id).subscribe(
      data => this.customer = data,
      error => console.log(error));
  }

  //method to decrement the number of passenger and also to change the total price
  onDecrement() {
    if (this.noOfCustomer != 1) {
      this.noOfCustomer--;
      this.rent = this.rent - this.ticketfare;
    }

  }
  
  //method to increment the number of passenger and also to change the total price
  onIncrement() {
    this.noOfCustomer++;
    this.rent = this.rent + this.ticketfare;
  }

}
