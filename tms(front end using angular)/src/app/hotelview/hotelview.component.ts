import { Component, OnInit } from '@angular/core';
import { Hotel } from '../model/Hotel';
import { HotelService } from '../services/hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotelview.component.html',
  styleUrls: ['./hotelview.component.css']
})

export class HotelviewComponent implements OnInit {

  hotels:Hotel[];
  hotelData: any;

  constructor(private hotelService: HotelService) {
    this.getHotles();
  }

  ngOnInit(): void { }

  // function to send Id of Selected Hotel to Booking Component
  onBook(id: number): void {
    this.hotelService.selectedHotelId = id;
  }

  // function to intialize varible to All Hotels
  getHotles() {
    this.hotelService.getAllHotels().subscribe(
      data => { 
        this.hotels = data;
      },
      error => {
        console.log('Error Occured')
        console.log(error);
      }
    );
  }

  
}


