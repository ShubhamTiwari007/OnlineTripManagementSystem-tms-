import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseURL = "http://localhost:8094";

  currentCustomerId:number=0;

  currentCustomerName:string = '';

  currentAdmin = 'null';

  constructor(private http:HttpClient) { }

  validateCustomer(username:string, password:string):Observable<any> {
    return this.http.get(`${this.baseURL}/validateCustomer/${username}/${password}`)
  }


}
