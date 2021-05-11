
import {​​​​​​​​ HttpClient }​​​​​​​​ from'@angular/common/http';
import {​​​​​​​​ Injectable }​​​​​​​​ from'@angular/core';
import {​​​​​​​​ Observable }​​​​​​​​ from'rxjs';
import { Hotel } from '../model/Hotel';
 
@Injectable({​​​​​​​​
providedIn:'root'
}​​​​​​​​)
export class HotelService {
 
  private baseUrl: string = 'http://localhost:8094';
 
  constructor(private http: HttpClient) { }

  selectedHotelId:any;

  addHotel(hotel: Hotel): Observable<any>{
    return this.http.post(`${this.baseUrl}/addhotels`,hotel);
  }

  getHotelById(id:number):Observable<any> {
    return this.http.get(`${this.baseUrl}/gethotelbyid/${id}`)
  }
 
  getAllHotels(): Observable<any> {
    return this.http.get(`${this.baseUrl}/gethotel`)
  }

  updateHotel(hotel: Hotel):Observable<any>{
    return this.http.put(`${this.baseUrl}/updatehotel`, hotel);
  }

  deleteHotel(id: number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/deletehotelbyid/${id}`,{responseType:'text'});
  }
}
