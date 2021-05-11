import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Station } from '../model/Station';

@Injectable({
  providedIn: 'root'
})
export class StationService {

  baseURL = "http://localhost:8094";

  constructor(private http:HttpClient) { }

  addStation(station: Station): Observable<any> {
    return this.http.post(`${this.baseURL}/addstation`, station)
  }

  getAllStation(): Observable<any> {
    return this.http.get(`${this.baseURL}/getstations`)
  }

  updateStation(stationValue: Station): Observable<any> {
    return this.http.put(`${this.baseURL}/updatestation`, stationValue);
  }

  deleteStation(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/deletestationbyid/${id}`, { responseType: 'text' });
  }

  getStationById(id: number): Observable<any> {
    return this.http.get(`${this.baseURL}/getstationbyid/${id}`)
  }

  getStationByName(name:string):Observable<any> {
    return this.http.get(`${this.baseURL}/getstationbyname/${name}`);
  } 
}
