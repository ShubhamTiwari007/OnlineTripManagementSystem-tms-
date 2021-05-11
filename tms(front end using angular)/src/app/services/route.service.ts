import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Route } from '../model/Route';

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  private baseURL = "http://localhost:8094"

  constructor(private http:HttpClient) { }

  addRoute(route: Route):Observable<any>{
    return this.http.post(`${this.baseURL}/addroute`,route);
  }
  
  getAllRoute(): Observable<any>{
    return this.http.get(`${this.baseURL}/getroutes`);
  }
  
  deleteRoute(id: number): Observable<any>{
    return this.http.delete(`${this.baseURL}/deleteroutebyid/${id}`,{responseType: 'text'})
  }

  getRoute(from:string, to:string):Observable<any> {
    return this.http.get(`${this.baseURL}/getroutebytostation/${from}/${to}`);
  }

  getRouteById(id: number): Observable<any> {
    return this.http.get(`${this.baseURL}/getroutebyid/${id}`);
  }
}
