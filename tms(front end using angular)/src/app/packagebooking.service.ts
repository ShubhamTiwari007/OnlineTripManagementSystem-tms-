import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PackageBooking } from './model/PackageBooking';

@Injectable({
  providedIn: 'root'
})
export class PackagebookingService {

  baseURL = "http://localhost:8094"

  constructor(private http:HttpClient) { }

  addPackageBooking(packageBooking:PackageBooking) {
    return this.http.post(`${this.baseURL}/addpackagebooking`, packageBooking);
  }

  getPackageBookingByCustomerId(id:number):Observable<any> {
    return this.http.get(`${this.baseURL}/getpackagebookingbycustomerid/${id}`);
  }

  deletePackageBookingById(id:number) {
    return this.http.delete(`${this.baseURL}/deletepackagebooking/${id}`);
  }
}
