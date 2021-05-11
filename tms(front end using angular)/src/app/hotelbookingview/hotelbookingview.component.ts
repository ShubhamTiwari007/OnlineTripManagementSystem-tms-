import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Customer } from '../model/Customer';
import { Hotel } from '../model/Hotel';
import { HotelBooking } from '../model/HotelBooking';
import { CustomerService } from '../services/customer.service';
import { HotelService } from '../services/hotel.service';
import { HotelbookingService } from '../services/hotelbooking.service';

@Component({
  selector: 'app-hotelbookingview',
  templateUrl: './hotelbookingview.component.html',
  styleUrls: ['./hotelbookingview.component.css']
})

export class HotelbookingviewComponent implements OnInit {

  hotel: Hotel = new Hotel();
  noOfCustomer: any = 1;
  totalamt: number;
  checkIn: Date;
  checkOut: Date;
  customer: Customer;

  date: any;

  // variables for validations
  today: any;
  


  constructor(private hotelservice: HotelService, private hotelBookingService: HotelbookingService, private customerService: CustomerService, private datepipe: DatePipe) {
    let id = this.hotelservice.selectedHotelId;
    this.getHotelById(id);

    this.customerService.getCustomerById(62).subscribe(data => {
      {
        this.customer = data;
      }
    });
    let todayDate = new Date();
    this.today = this.datepipe.transform(todayDate, 'yyyy-MM-dd');
  }

  ngOnInit(): void {
  }

  getHotelById(id: number) {
    return this.hotelservice.getHotelById(id).subscribe(
      data => {
        this.hotel = data;
        this.totalamt = this.hotel.rent;
      },
      error => {
        console.log(error);
      }
    )
  }

  storeBooking() {
    console.log(this.customer.name);

    let hotelBooking = new HotelBooking(this.noOfCustomer, this.totalamt, 'Ticket Booked', '', this.checkIn, this.checkOut, this.customer, this.hotel);
    console.log(hotelBooking);
    this.addHotelBooking(hotelBooking);
    alert('Hotel Booked')
  }

  addHotelBooking(hotelBooking: HotelBooking) {
    this.hotelBookingService.addHotelBooking(hotelBooking).subscribe(
      date => {
        console.log("Successfully Added...");
      },
      error => {
        console.log("Not Added..");

      })
  }

  // Caclulate the Total Amount if No. of Customer Increases
  onDecrement() {
    if (this.noOfCustomer != 1) {
      this.noOfCustomer--;
      this.totalamt = this.totalamt - this.hotel.rent;
    }
  }

  // Caclulate the Total Amount if No. of Customer Deccreases
  onIncrement() {
    if (this.noOfCustomer < 10) {
      this.noOfCustomer++;
      this.totalamt = this.totalamt + this.hotel.rent;
    }
  }
}
