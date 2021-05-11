import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../model/Feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private baseUrl: string=`http://localhost:8094`;

  constructor(private http:HttpClient) { }
  
  addFeedback(feedback: Feedback): Observable<any> {
    return this.http.post(`${this.baseUrl}/addfeedback`, feedback)
  }

  getFeedbacks(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getfeedbacks`)
  }

  deleteFeedback(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deletefeedbackbyid/${id}`, { responseType: 'text' });
  }

  getFeedbacksById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getfeedbackbyid/${id}`)
  }
}
