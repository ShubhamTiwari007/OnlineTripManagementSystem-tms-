import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../model/Customer';
import { User } from '../model/User';
import { AuthService } from '../services/auth.service';
import { CustomerService } from '../services/customer.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  val;
  constructor(private loginService: LoginService, private customerService: CustomerService, private router:Router, private authService:AuthService) {
      
    // this.getCustomerByUsername("karan1");
   }
  hide = true;

  username = new FormControl('', [Validators.required]);
  password = new FormControl('');
  role = new FormControl('');

  uname;
  pass;

  flag: boolean = false;

  customer:Customer = new Customer();

  getErrorMessage() {
    if (this.username.hasError('required')) {
      return 'You must enter a value';
    }
    if (this.password.hasError('required')) {
      return 'You must enter a value';
    }
    if (this.role.hasError('required')) {
      return 'You must choose a value';
    }
    return this.username.hasError('username') ? 'Not a valid User' : '';
  }
  ngOnInit(): void {
    this.val = this.loginService.currentCustomerName+" Current";
      
  }

  isCustomerValid(username: any, password: any): boolean {
    this.loginService.validateCustomer(username, password).subscribe(
      data => {
        this.loginService.currentCustomerName = username;
        console.log(this.loginService.currentCustomerName);
        console.log("Login Page");
          this.router.navigate(['/myprofile']); 
      },
      error => {
      }
    )
    return false;
  }

  getCustomerByUsername(username) {
    this.customerService.getCustomerByUsername(username).subscribe(
      data => {
        setTimeout(() => {
          this.customer = data;
        }, 4000);
      }
    )
  }

  loginCheck() {
    if(this.role.value=='Admin') {
      if(this.username.value=='Admin' && this.password.value=='admin') {
        this.loginService.currentAdmin = 'Admin';
      } 
    }
    else {
      this.isCustomerValid(this.username.value, this.password.value);
    }
   
    // console.log("safs");
    // if (this.role.value === "Customer") {
    //   let uname:string;
    //   let pass:string;
    //   console.log("first before");
    //   console.log(this.username.value);
    //     console.log(this.username.value);

    //   this.loginService.validateCustomer(this.username.value, this.password.value).subscribe(
    //     data => {

    //       // if (data) {
          
    //       // }

          
    //     },
    //     error => {
    //     }
    //   )
    // }
  }
}

