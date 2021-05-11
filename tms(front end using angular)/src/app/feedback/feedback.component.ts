import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Feedback } from '../model/Feedback';
import { FeedbackService } from '../services/feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {


  constructor(private feedbackService: FeedbackService) { 
  }

  ngOnInit(): void {
    this.addFeedback();
  }
  message: string = '';
  deleteMessage: boolean = false;
  isSaved: boolean = false;
  id: number
  description: string = ''
  rating: string = ''
  feedback: Feedback = new Feedback();
  feedbacks : Feedback[] = [];
  feedbacknList: any;
  

  saveFeedback = new FormGroup({
    fdescription: new FormControl(''),
    frating: new FormControl('')
  });

  //getters
  get feedackDescription() {
    return this.saveFeedback.get('fdescription')
  }

  get FeedbackRating() {
    return this.saveFeedback.get('frating')
  }
   
  addFeedback() {
    this.feedback = new Feedback();
    this.feedback.description = this.feedackDescription.value;
    this.feedback.rating = this.FeedbackRating.value;
    this.feedbackService.addFeedback(this.feedback).subscribe(
      data => {
        console.log(data);
        this.getFeedback();
      },
      error => console.log(error));
    this.isSaved = true;
    this.description = '';
    this.rating = '';
 
  }

  getFeedback() {
    this.feedbackService.getFeedbacks().subscribe(
      data => this.feedback = data,
      error => {
        this.feedbacks = [];
        console.log(error);
      }
    );
  }

  getFeedbackById(id: number){
    this.feedbackService.getFeedbacksById(id).subscribe(
      data => this.feedback = data,
      error => console.log(error)    
    );
  }

  
  deleteStation(id: number){
    this.feedbackService.deleteFeedback(id).subscribe(
      data => {
        this.message = data;
        this.deleteMessage = true;
        this.getFeedback();
      },
      error => console.log(error));
  }

}
