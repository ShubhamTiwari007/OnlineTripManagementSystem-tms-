import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../model/User';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // private loggedIn = new BehaviorSubject<boolean>(false); // {1}

  private loggedIn = new BehaviorSubject<boolean>(false); // {1}
  

  get isLoggedIn() {
    return this.loggedIn.asObservable(); // {2}
  }

  constructor(
    private router: Router,
    private loginService:LoginService
  ) {}

  login(user: User){
    if (user.username !== '' && user.password !== '' ) { // {3}
      this.loggedIn.next(true);
      // console.log(this.loginService.currentCustomerId);
      this.router.navigate(['/hotel']);
    }
  }

  logout() {                            // {4}
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}