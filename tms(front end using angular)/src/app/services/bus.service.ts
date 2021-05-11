import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bus } from '../model/Bus';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  baseURL = "http://localhost:8094"

  constructor(private http:HttpClient) { }

  addBus(bus: Bus): Observable<any>{
    return this.http.post(`${this.baseURL}/addbus`,bus);
  }

  getAllBus(): Observable<any>{
    return this.http.get(`${this.baseURL}/getbuses`);
  }

  updateBus(busValue: Bus): Observable<any>{
    return this.http.put(`${this.baseURL}/updatebus`,busValue);
  }

  deleteBus(id: number): Observable<any>{
    return this.http.delete(`${this.baseURL}/deletebusbyid/${id}`,{responseType: 'text'});
  }

  getBusById(id:number):Observable<any> {
    return this.http.get(`${this.baseURL}/getbusbyid/${id}`);
  }
  
}

