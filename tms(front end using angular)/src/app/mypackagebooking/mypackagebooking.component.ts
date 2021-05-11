import { Component, OnInit } from '@angular/core';
import { PackageBooking } from '../model/PackageBooking';
import { PackagebookingService } from '../packagebooking.service';

@Component({
  selector: 'app-mypackagebooking',
  templateUrl: './mypackagebooking.component.html',
  styleUrls: ['./mypackagebooking.component.css']
})
export class MypackagebookingComponent implements OnInit {

  packagebookings:PackageBooking[];

  constructor(private packageBookingService:PackagebookingService) { 
    this.getPackageBookingByCustomerId(62);
  }



  ngOnInit(): void {
  }

  getPackageBookingByCustomerId(id:number) {
    this.packageBookingService.getPackageBookingByCustomerId(id).subscribe(
      data => {
        this.packagebookings = data;
      }, error => {
        console.log("Something went wrong");
      }
    )
  }

  onDelete(id:number) {
    this.packageBookingService.deletePackageBookingById(id).subscribe(
      data => {
        this.getPackageBookingByCustomerId(62);
        alert("Package Booking Deleted...");
      }, error => {
        this.getPackageBookingByCustomerId(62);
        alert("Package Booking Deleted...");
      }
      )
  }

}
