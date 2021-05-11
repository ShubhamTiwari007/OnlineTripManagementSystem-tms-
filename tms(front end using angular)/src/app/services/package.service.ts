import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Package } from '../model/Package';

@Injectable({
  providedIn: 'root'
})
export class PackageService {

  private baseURL = "http://localhost:8094";

  selectedPackageId:any;
  selectedHotelId:any;

  constructor(private http:HttpClient) { }

  addPackage(pack: Package):Observable<any>{
    return this.http.post(`${this,this.baseURL}/addpackage`,pack);
  }


  updatePackage(pack: Package): Observable<any>{
    return this.http.put(`${this.baseURL}/updatepackage`,pack);
  }

  deletePackage(id: number):Observable<any>{
    return this.http.delete(`${this.baseURL}/deletepackagebyid/${id}`,{responseType: 'text'})
  }

  getPackage():Observable<any> {
    return this.http.get(`${​​​​​​​​this.baseURL}/getpackages`)
  }

  getPackageById(id:number):Observable<any> {
    return this.http.get(`${this.baseURL}/getpackagebyid/${id}`)
  }

}
