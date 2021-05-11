import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  noOfCustomers:number;
  noOfHotels:number;
  noOfPackages:number;
  noOfBuses:number;

  count:number;

  constructor(private customerService:CustomerService) { 
    // this.count = this.getNoOfCustomers;
    this.getNoOfCustomers();
  }

  ngOnInit(): void {
  }

  getNoOfCustomers() {
    // console.log("Hey");
    
    // console.log(this.customerService.getAllCustomers().subscribe.length);
    ;
  }


}
