import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router, private authService:AuthService) { 
  }
  
  isLoggedIn:boolean=false;

  ngOnInit(): void {
    if(this.loginService.currentCustomerName==='' ||  this.loginService.currentCustomerName==null) {
      this.isLoggedIn = true;
      console.log("No Login someone");
    }
    else {
      this.isLoggedIn = true;
      console.log("Someone Logged In");
    }
  }

  onRefresh() {
    this.ngOnInit();
  }

  onLogout() {
  this.loginService.currentCustomerName='';
   this.isLoggedIn = false;
   this.router.navigate(['']);
  }


}
