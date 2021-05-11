import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Station } from '../model/Station';
import { StationService } from '../services/station.service';

@Component({
  selector: 'app-stationmanage',
  templateUrl: './stationmanage.component.html',
  styleUrls: ['./stationmanage.component.css']
})
export class StationmanageComponent implements OnInit {

  constructor(private stationService: StationService) { }

  ngOnInit(): void {
    this.getStations();
    this.isupdated=false;
  }

  isupdated = false; 
  message: string = '';
  deleteMessage: boolean = false;
  isSaved: boolean = false;
  name: String = ''
  code: String = ''
  station: Station = new Station();
  stations: Station[] = [];
  

  saveStation = new FormGroup({
    sname: new FormControl(''),
    scode: new FormControl('')
  });

  stationupdateform = new FormGroup({
    uid: new FormControl(),
    uname: new FormControl(),
    ucode: new FormControl()
  });

  addStation() {
    this.station = new Station();
    this.station.name = this.saveStation.get('sname').value;
    this.station.code = this.saveStation.get('scode').value;
    this.stationService.addStation(this.station).subscribe(
      data => {
        console.log(data);
        this.getStations();
      },
      error => console.log(error));
    this.isSaved = true;
    this.name = '';
    this.code = '';
    this.station = new Station();
 
  }

  getStations() {
    this.stationService.getAllStation().subscribe(
      data => this.stations = data,
      error => {
        this.stations = [];
        console.log(error);
      });
  }

  getStation(id: number){
    this.stationService.getStationById(id).subscribe(
      data => this.station = data,
      error => console.log(error)    
    );
  }
  
  updateStationDetails(){
    this.station = new Station();
    this.station.id = this.stationupdateform.get('uid').value;
    this.station.name = this.stationupdateform.get('uname').value;
    this.station.code = this.stationupdateform.get('ucode').value;
    this.stationService.updateStation(this.station).subscribe(
      data => {
        console.log(data);
        this.getStations();
        this.isupdated = true;
      },
      error => console.log(error));
  }

  deleteStation(id: number){
    this.stationService.deleteStation(id).subscribe(
      data => {
        this.message = data;
        this.deleteMessage = true;
        this.getStations();
      },
      error => console.log(error));
  }

  changeisUpdate(){
    this.isupdated=false;
  }
}
