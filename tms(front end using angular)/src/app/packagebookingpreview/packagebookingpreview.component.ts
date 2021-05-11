import { Component, OnInit } from '@angular/core';
import { BusBooking } from '../model/BusBooking';
import { Customer } from '../model/Customer';
import { Hotel } from '../model/Hotel';
import { Package } from '../model/Package';
import { PackageBooking } from '../model/PackageBooking';
import { PackagebookingService } from '../packagebooking.service';
import { CustomerService } from '../services/customer.service';
import { HotelService } from '../services/hotel.service';
import { PackageService } from '../services/package.service';

@Component({
  selector: 'app-packagebookingpreview',
  templateUrl: './packagebookingpreview.component.html',
  styleUrls: ['./packagebookingpreview.component.css']
})
export class PackagebookingpreviewComponent implements OnInit {

  package: Package = new Package();
  hotel: Hotel = new Hotel();
  noOfCustomer: any = 1;
  totalamt: number;
  plannedDate: Date;

  customer:Customer;
  busBooking:BusBooking;

  constructor(private packageService: PackageService, private hotelService: HotelService, private customerService:CustomerService, private packageBookingService:PackagebookingService) {
    console.log(this.packageService.selectedHotelId + " " + this.packageService.selectedPackageId);
    this.getPackageById(this.packageService.selectedPackageId);
    this.getHotelById(this.packageService.selectedHotelId);

    this.customerService.getCustomerById(62).subscribe(data => {
      {
        this.customer = data;
      }
    });

  }

  ngOnInit(): void {
  }

  getPackageById(id: number) {
    this.packageService.getPackageById(id).subscribe(
      data => {
        this.package = data;
        this.totalamt = this.package.price;
        // this.totalamt = this.package.price;
        // console.log(this.package);

      }
    )
  }

  getHotelById(id: number) {
    return this.hotelService.getHotelById(id).subscribe(
      data => {
        this.hotel = data;
        // console.log(this.hotel);

      },
      error => {
        console.log(error);
      }
    )
  }

  storePackageBooking() {
    let packageBooking = new PackageBooking(this.customer, new Date(), this.noOfCustomer, this.totalamt, " ", this.plannedDate, this.hotel, this.package);
   console.log(packageBooking);
   this.addPackageBooking(packageBooking);
   }

  addPackageBooking(packageBooking:PackageBooking) {
    this.packageBookingService.addPackageBooking(packageBooking).subscribe(
      data => {
        alert('Package Booked..');
      }, error => {
        alert("Somethinkg went wrong");
      }
    )
  }

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
