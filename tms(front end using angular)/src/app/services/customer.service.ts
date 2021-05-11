import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  baseURL = "http://localhost:8094";

  constructor(private http:HttpClient) { }

  getCustomerById(id:number):Observable<any> {
    return this.http.get(`${this.baseURL}/getcustomerbyid/${id}`)
  }

  getAllCustomers():Observable<any> {
    return this.http.get(`${this.baseURL}/getcustomers`);
  }

  getCustomerByUsername(username:string):Observable<any> {
    return this.http.get(`${this.baseURL}/getcustomerbyusername/${username}`)
  }
}
