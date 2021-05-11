import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Hotel } from '../model/Hotel';
import { Package } from '../model/Package';
import { HotelService } from '../services/hotel.service';
import { PackageService } from '../services/package.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
declare let $: any;

@Component({
  selector: 'app-packagemanage',
  templateUrl: './packagemanage.component.html',
  styleUrls: ['./packagemanage.component.css']
})
export class PackagemanageComponent implements OnInit {

  //declared variables
  packages: Package[] = [];
  hotels: Hotel[] = [];
  package: Package = new Package();
  packageName: string;
  packageDestination: string;
  packageDuration: string;
  packageDescription: string;
  packagePrice: number;
  packageHotels: Hotel[];
  savePackage: FormGroup;
  isupdated: boolean = false;

  //constructor
  constructor(private packageService: PackageService, private hotelService: HotelService, private formBuilder: FormBuilder) {

    this.packageService.getPackage().subscribe(
      data => {
        this.packages = data;
        //Destroy old datatable for getting new latest data
        $('#packageDataTable').DataTable().destroy();
        //get package details sevice and show inside datatable
        this.packageService.getPackage().subscribe(
          data => {
            this.packages = data;
            setTimeout(() => { $('#packageDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error)
    );

    //adding validation to form feilds
    this.savePackage = this.formBuilder.group({
      addName: ['', Validators.required],
      addDestination: ['', Validators.required],
      addDuration: ['', Validators.required],
      addDescription: ['', Validators.required],
      addPrice: ['', Validators.required],
      addHotels: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.isupdated = false;
  }

  //form group for updating the values
  packageupdateform = new FormGroup({
    updateId: new FormControl(),
    updateName: new FormControl(),
    updateDestination: new FormControl(),
    updateDuration: new FormControl(),
    updateDescription: new FormControl(),
    updatePrice: new FormControl(),
    updateHotels: new FormControl()
  });

  addNewPackage() {
    this.getHotels();
    $("#addPackageModel").modal("show");
  }

  //adding package data from for to the database
  addPackage() {
    this.package = new Package();
    this.package.name = this.packageName;
    this.package.destination = this.packageDestination;
    this.package.duration = this.packageDuration
    this.package.description = this.packageDescription
    this.package.price = this.packagePrice
    this.package.hotels = this.packageHotels
    this.packageService.addPackage(this.package).subscribe(
      data => {
        console.log(data);
        this.packageName = '';
        this.packageDestination = '';
        this.packageDuration = '';
        this.packageDescription = '';
        this.packagePrice = 0
        this.packageHotels = [];
      },
      error => console.log(error));
    this.packageService.getPackage().subscribe(
      data => {
        this.packages = data;
        $("#addPackageModel").modal("hide");
        //sweetalert message popup
        Swal.fire({
          title: 'Completed',
          text: "Package has been added successfully",
          icon: 'success'
        });
        //Destroy old datatable for getting new latest data
        $('#packageDataTable').DataTable().destroy();
        //get user details sevice and show inside datatable
        this.packageService.getPackage().subscribe(
          data => {
            this.packages = data;
            setTimeout(() => { $('#packageDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error));
  }

  //method to get all the package data
  getPackages() {
    this.packageService.getPackage().subscribe(
      data => this.packages = data,
      error => {
        this.packages = [];
        console.log(error);
      });
  }

  //method to get package data using package id
  getPackage(id: number) {
    this.getHotels();
    this.packageService.getPackageById(id).subscribe(
      data => this.package = data,
      error => console.log(error));
  }

  //method to get all hotel data
  getHotels() {
    this.hotelService.getAllHotels().subscribe(
      data => this.hotels = data,
      error => console.log(error));
  }

  //method to update package information
  updatePackageDetails() {
    this.package = new Package();
    this.package.id = this.packageupdateform.get('updateId').value;
    this.package.name = this.packageupdateform.get('updateName').value;
    this.package.destination = this.packageupdateform.get('updateDestination').value;
    this.package.duration = this.packageupdateform.get('updateDuration').value;
    this.package.description = this.packageupdateform.get('updateDescription').value;
    this.package.price = this.packageupdateform.get('updatePrice').value;
    this.package.hotels = this.packageupdateform.get('updateHotels').value;
    this.packageService.updatePackage(this.package).subscribe(
      data => {
        console.log(data);
        this.getPackages();
        this.isupdated = true;
      },
      error => console.log(error));
  }

  //method to delete the package data
  deletePackage(id: number) {
    this.packageService.deletePackage(id).subscribe(
      data => console.log(data),
      error => console.log(error));

    this.packageService.getPackage().subscribe(
      data => {
        this.packages = data;
        //sweetalert message popup
        Swal.fire({
          title: 'Completed',
          text: "Package has been deleted successfully",
          icon: 'success'
        });
        //Destroy old datatable for getting new latest data
        $('#packageDataTable').DataTable().destroy();
        //get user details sevice and show inside datatable
        this.packageService.getPackage().subscribe(
          data => {
            this.packages = data;
            setTimeout(() => { $('#packageDataTable').DataTable() }, 500);
          });
      },
      error => console.log(error));
  }

  //method called on button click to change the value
  changeisUpdate() {
    this.isupdated = false;
  }
}

