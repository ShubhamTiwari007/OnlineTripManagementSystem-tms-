import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/Customer';
import { Signup } from '../model/Signup';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private baseUrl: string = 'http://localhost:8094';

  constructor(private http: HttpClient) { }

  addSignupDetail(customer: Signup): Observable<any> {
    return this.http.post(`${this.baseUrl}/addcustomer`, customer)
  }
}