import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusBooking } from '../model/BusBooking';

@Injectable({
  providedIn: 'root'
})
export class BusbookingService {

  constructor(private http:HttpClient) { }

  selected:any;

  busSelected:any;

  baseURL = "http://localhost:8094";

  // busSelected:any = 143;
  set setSelected(selected) {
    this.selected = selected;
  }

  get getSelected() {
    return this.selected;
  }

  addBusBooking(busBooking:BusBooking) {
    return this.http.post(`${this.baseURL}/addbusbooking`, busBooking);
  }

  getAllBusBookingByCustomerId(id:number):Observable<any> {
    return this.http.get(`${this.baseURL}/getbusbookingsbycustomerid/${id}`);
  }

  deleteBusBookingById(id: number): Observable<any>{
    return this.http.delete(`${this.baseURL}/deletebusbooking/${id}`,{responseType: 'text'})
  }
}
