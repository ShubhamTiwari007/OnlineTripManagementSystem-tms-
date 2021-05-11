import { Component, OnInit } from '@angular/core';
import { BusBooking } from '../model/BusBooking';
import { BusbookingService } from '../services/busbooking.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-mybusbooking',
  templateUrl: './mybusbooking.component.html',
  styleUrls: ['./mybusbooking.component.css']
})
export class MybusbookingComponent implements OnInit {

  //declared variables
  busbookings: BusBooking[];

  //constructor
  constructor(private busBookingService: BusbookingService) {
    this.getBusBookingByCustomerId(26);
  }

  ngOnInit(): void {
  }

  //method to get bus booking data using cutomer id
  getBusBookingByCustomerId(id: number) {
    this.busBookingService.getAllBusBookingByCustomerId(id).subscribe(
      data => {
        this.busbookings = data;
        console.log(data);
      },
      error => console.log(error));
  }

  //metho to delete bus booking using bus booking id
  deleteBusBookingById(id: number) {
    this.busBookingService.deleteBusBookingById(id).subscribe(
      data => {
        console.log(data);
        //sweet alert to confirm the deletion of booking
        Swal.fire({
          title: 'Completed',
          text: "Booking has been deleted",
          icon: 'success'
        });
        this.getBusBookingByCustomerId(26);
      },
      error => console.log(error));
  }
}
