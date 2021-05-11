import { Component, OnInit } from '@angular/core';
import { BusBooking } from '../model/BusBooking';
import { Customer } from '../model/Customer';
import { HotelBooking } from '../model/HotelBooking';
import { PackageBooking } from '../model/PackageBooking';
import { PackagebookingService } from '../packagebooking.service';
import { BusbookingService } from '../services/busbooking.service';
import { CustomerService } from '../services/customer.service';
import { HotelbookingService } from '../services/hotelbooking.service';

@Component({
  selector: 'app-customerprofile',
  templateUrl: './customerprofile.component.html',
  styleUrls: ['./customerprofile.component.css']
})
export class CustomerprofileComponent implements OnInit {

  today = new Date();

  bookingsrc = "";
  
  currentCustomer:Customer = new Customer();

  hotelBookings:HotelBooking[];

  packageBookings:PackageBooking[];

  busBooking: BusBooking[];

  pBookingLen:number;

  hBookingLen:number; 

  bBookingLen:number;

  constructor(private customerService:CustomerService, private hotelBookingService:HotelbookingService, private packageBookingService:PackagebookingService, private busBookingService: BusbookingService) { 

    this.customerService.getCustomerByUsername("karan1").subscribe(
      data => {
        this.currentCustomer = data;
      },
      errror => {
        console.log("Nothing");
        
      }
    )

    this.hotelBookingService.getHotelBookingByCustomerId(62).subscribe(
      data => {
        this.hotelBookings = data;
        this.hBookingLen = this.hotelBookings.length;
      },
      errors => {
        console.log("No Bookings");
      }
    )

      this.packageBookingService.getPackageBookingByCustomerId(62).subscribe(
        data => {
          this.packageBookings = data;
          this.pBookingLen = this.packageBookings.length;
        }, error => {
          console.log("Something went wrong");
          
        }
      )

      this.busBookingService.getAllBusBookingByCustomerId(26).subscribe(
        data => {
          this.busBooking = data;
          this.bBookingLen = this.busBooking.length;
        },
        error => {
          console.log("Something went wrong");
        }
      )

  }



  ngOnInit(): void {
    setInterval(() => {
      this.today = new Date();
      }, 1000);
  }

  


}
