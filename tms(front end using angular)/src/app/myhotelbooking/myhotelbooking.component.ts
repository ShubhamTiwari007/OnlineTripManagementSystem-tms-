import { Component, OnInit } from '@angular/core';
import { HotelBooking } from '../model/HotelBooking';
import { HotelbookingService } from '../services/hotelbooking.service';

@Component({
  selector: 'app-myhotelbooking',
  templateUrl: './myhotelbooking.component.html',
  styleUrls: ['./myhotelbooking.component.css']
})
export class MyhotelbookingComponent implements OnInit {

  hotelbookings: HotelBooking[];

  constructor(private hotelBookingService: HotelbookingService) {

    this.getHotelBookingByCustomerId(62);

  }



  ngOnInit(): void {
  }

  getHotelBookingByCustomerId(id:number) {
    this.hotelBookingService.getHotelBookingByCustomerId(id).subscribe(
      data => {
        this.hotelbookings = data;
      },
      errors => {
        console.log("No Bookings");
      }
    )
  }

  onDelete(id: number) {
    console.log(id);
    
    this.hotelBookingService.deleteHotelBookingById(id).subscribe(
      data => {
        alert("Booking is Canceled...");
        this.getHotelBookingByCustomerId(62);
      },
      errors => {
        alert("Booking is Canceled...");
        this.getHotelBookingByCustomerId(62);
      }
    )
  }

}


