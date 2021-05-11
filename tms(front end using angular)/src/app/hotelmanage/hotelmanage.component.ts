import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Hotel } from '../model/Hotel';
import { HotelService } from '../services/hotel.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
declare let $: any;

@Component({
  selector: 'app-hotelmanage',
  templateUrl: './hotelmanage.component.html',
  styleUrls: ['./hotelmanage.component.css']
})
export class HotelmanageComponent implements OnInit {

  //decalred variables
  isupdated = false;
  name: String = ''
  address: String = ''
  description: String = ''
  rent: number
  hotel: Hotel = new Hotel();
  hotels: Hotel[] = [];
  saveHotel: FormGroup

  //form group for taking values
  hotelupdateform = new FormGroup({
    uid: new FormControl(),
    uname: new FormControl(),
    uaddress: new FormControl(),
    udescription: new FormControl(),
    urent: new FormControl()
  });

  //constructor
  constructor(private hotelService: HotelService, private formBuilder: FormBuilder) {
    this.hotelService.getAllHotels().subscribe(
      data => {
        this.hotels = data;

        //Destroy old datatable for getting new latest data
        $('#hotelDataTable').DataTable().destroy();

        //get hotel details sevice and show inside datatable
        this.hotelService.getAllHotels().subscribe(
          data => {
            this.hotels = data;
            setTimeout(() => { $('#hotelDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error)
    );

    //applying validations in the form
    this.saveHotel = this.formBuilder.group({
      hname: ['', Validators.required],
      haddress: ['', Validators.required],
      hdescription: ['', Validators.required],
      hrent: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getHotels();
    this.isupdated = false;
  }

  addNewHotel() {
    $("#addHotelModel").modal("show");
  }

  //method to add hotel data to the database and show using datatables
  addHotel() {
    this.hotel = new Hotel();
    this.hotel.name = this.saveHotel.get('hname').value;
    this.hotel.address = this.saveHotel.get('haddress').value;
    this.hotel.description = this.saveHotel.get('hdescription').value;
    this.hotel.rent = this.saveHotel.get('hrent').value;

    this.hotelService.addHotel(this.hotel).subscribe(
      data => {
        console.log(data);
        this.name = '';
        this.address = '';
        this.description = '';
        this.rent = 0;
        this.hotel = new Hotel();
      },
      error => console.log(error)
    );
    this.hotelService.getAllHotels().subscribe(
      data => {
        this.hotels = data;
        $("#addHotelModel").modal("hide");
        //sweetalert message popup
        Swal.fire({
          title: 'Completed',
          text: "Hotel has been added successfully",
          icon: 'success'
        });
        //Destroy old datatable for getting new latest data
        $('#hotelDataTable').DataTable().destroy();

        //get hotel details sevice and show inside datatable
        this.hotelService.getAllHotels().subscribe(
          data => {
            this.hotels = data;
            setTimeout(() => { $('#hotelDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error)
    );
  }

  //method to get all the data from hotel 
  getHotels() {
    this.hotelService.getAllHotels().subscribe(
      data => this.hotels = data,
      error => {
        this.hotels = [];
        console.log(error);
      }
    );
  }

  //method to get hotel data using hotel id
  getHotel(id: number) {
    this.hotelService.getHotelById(id).subscribe(
      data => this.hotel = data,
      error => console.log(error)
    );
  }

  //method to update the hotel information
  updateHotelDetails() {
    this.hotel = new Hotel();
    this.hotel.id = this.hotelupdateform.get('uid').value;
    this.hotel.name = this.hotelupdateform.get('uname').value;
    this.hotel.address = this.hotelupdateform.get('uaddress').value;
    this.hotel.description = this.hotelupdateform.get('udescription').value;
    this.hotel.rent = this.hotelupdateform.get('urent').value;
    this.hotelService.updateHotel(this.hotel).subscribe(
      data => {
        console.log(data);
        this.getHotels();
        this.isupdated = true;
      },
      error => console.log(error));
  }

  //method to delete hotel data using hotel id
  deleteHotel(id: number) {
    this.hotelService.deleteHotel(id).subscribe(
      data => console.log(data),
      error => {
        console.log(error)
        Swal.fire({
          title: 'Something went wrong',
          text: "Hotel not deleted, associated with package",
          icon: 'error'
        });
      });
    this.hotelService.getAllHotels().subscribe(
      data => {
        this.hotels = data;
        $("#addHotelModel").modal("hide");
        //sweetalert message popup
        Swal.fire({
          title: 'Completed',
          text: "Hotel has been added successfully",
          icon: 'success'
        });
        //Destroy old datatable for getting new latest data
        $('#hotelDataTable').DataTable().destroy();

        //get user details sevice and show inside datatable
        this.hotelService.getAllHotels().subscribe(
          data => {
            this.hotels = data;
            setTimeout(() => { $('#hotelDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error));
  }

  //method to chnage the value when button click
  changeisUpdate() {
    this.isupdated = false;
  }
}
