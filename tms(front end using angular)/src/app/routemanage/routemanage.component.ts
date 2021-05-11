import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Bus } from '../model/Bus';
import { Route } from '../model/Route';
import { Station } from '../model/Station';
import { BusService } from '../services/bus.service';
import { RouteService } from '../services/route.service';
import { StationService } from '../services/station.service';

@Component({
  selector: 'app-routemanage',
  templateUrl: './routemanage.component.html',
  styleUrls: ['./routemanage.component.css']
})
export class RoutemanageComponent implements OnInit {

  routes: Route[] = [];
  stations: Station[] = [];
  buses: Bus[] = [];
  route: Route = new Route();
  stationFrom: Station;
  stationTo: Station;
  bus: Bus[] =[];
  isSaved: boolean = false;
  message: string ='';
  deleteMessage: boolean = false;

  constructor(private routeService: RouteService, private stationService: StationService, private busService: BusService) {
    this.getRoutes();
    this.getStations();
    this.getBuses()
  }

  ngOnInit(): void {
  }

  saveRoute = new FormGroup({
    addFrom: new FormControl(),
    addTo: new FormControl(),
    addBuses: new FormControl()
  });

  addRoute() {
    this.route = new Route();
    this.route.from = this.stationFrom;
    this.route.to = this.stationTo;
    this.route.buses = this.bus;
    this.routeService.addRoute(this.route).subscribe(
      data => {
        console.log(data);
        this.getRoutes();
      },
      error => console.log(error));
    this.isSaved = true;
    this.stationFrom = new Station();
    this.stationTo = new Station();
    this.bus = [];
    this.route = new Route();
  }

  getRoutes() {
    this.routeService.getAllRoute().subscribe(
      data => this.routes = data,
      error => console.log(error)
    );
  }

  getStations() {
    this.stationService.getAllStation().subscribe(
      data => this.stations = data,
      error => console.log(error)
    );
  }

  getBuses() {
    this.busService.getAllBus().subscribe(
      data => this.buses = data,
      error => console.log(error)
    );
  }

  getRoute(id: number){
    this.routeService.getRouteById(id).subscribe(
      data =>{ 
        this.route = data;
        console.log(this.route)
      },
      error => console.log(error)
    );
  }

  deleteRoute(id: number){
    this.routeService.deleteRoute(id).subscribe(
      data => {
        this.message = data;
        this.deleteMessage = true;
        this.getRoutes();
      },
      error => console.log(error));
  }

}
