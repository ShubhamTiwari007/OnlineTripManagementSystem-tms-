import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/Customer';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-customermanage',
  templateUrl: './customermanage.component.html',
  styleUrls: ['./customermanage.component.css']
})
export class CustomermanageComponent implements OnInit {

  customerdetail : Customer[] = [];

  constructor(private customerservice:CustomerService) {
    $('#customerDataTable').DataTable()
  }
  
  ngOnInit(): void{
    this.getCustomerDetails();  
  }
  
  getCustomerDetails() {
    this.customerservice.getAllCustomers().subscribe(
      data => this.customerdetail = data,
      error => {
        this.customerdetail = [];
        console.log(error);
      });
  }

}