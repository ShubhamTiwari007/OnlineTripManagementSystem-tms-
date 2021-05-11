import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Bus } from '../model/Bus';
import { BusService } from '../services/bus.service';

@Component({
  selector: 'app-busmanage',
  templateUrl: './busmanage.component.html',
  styleUrls: ['./busmanage.component.css']
})
export class BusmanageComponent implements OnInit {

  busnum: string = '';
  currentEmptySeat: number;
  driver: string = '';
  conductor: string = '';
  dept: string = '';
  arr: string = '';
  amount: number;

  buses: Bus[] = [];
  bus: Bus = new Bus();
  isSaved: boolean = false;
  isupdated: boolean = false; 
  message: string = '';
  deleteMessage: boolean = false;


  constructor(private busService: BusService) { }

  ngOnInit(): void {
    this.getBuses();
    this.isupdated=false;
  }

  saveBus = new FormGroup({
    bnumber: new FormControl(''),
    busdriver: new FormControl(''),
    busconductor: new FormControl(''),
    busdept: new FormControl(''),
    busarr: new FormControl(''),
    busamt: new FormControl(''),
    busseat: new FormControl('')
  });

  busupdateform = new FormGroup({
    updateid: new FormControl(),
    updatenumber: new FormControl(),
    updatedriver: new FormControl(),
    updateconductor: new FormControl(),
    updatedept: new FormControl(),
    updatearr: new FormControl(),
    updateamt: new FormControl(),
    updateseat: new FormControl()
  });

  addBus() {
    this.bus = new Bus();
    this.bus.busNumber = this.saveBus.get('bnumber').value;
    this.bus.driver = this.saveBus.get('busdriver').value;
    this.bus.conductor = this.saveBus.get('busconductor').value;
    this.bus.dep = this.saveBus.get('busdept').value;
    this.bus.arr = this.saveBus.get('busarr').value;
    this.bus.amount = this.saveBus.get('busamt').value;
    this.bus.currentEmptySeat = this.saveBus.get('busseat').value;
    this.busService.addBus(this.bus).subscribe(
      data => {
        console.log(data);
        this.getBuses();
      },
      error => console.log(error));
    this.isSaved = true;
    this.busnum = '';
    this.currentEmptySeat = 0;
    this.driver = '';
    this.conductor = '';
    this.dept = '';
    this.arr = '';
    this.amount = 0;
    this.bus = new Bus();
}

  getBuses() {
    this.busService.getAllBus().subscribe(
      data => this.buses = data,
      error => {
        this.buses = [];
        console.log(error)
      });
  }

  getBus(id: number){
    this.busService.getBusById(id).subscribe(
      data=> this.bus = data,
      error => {
        console.log(error)
      });
  }

  updateBusDetails(){
    this.bus = new Bus();
    this.bus.id = this.busupdateform.get('updateid').value;
    this.bus.busNumber = this.busupdateform.get('updatenumber').value;
    this.bus.driver = this.busupdateform.get('updatedriver').value;
    this.bus.conductor = this.busupdateform.get('updateconductor').value;
    this.bus.dep = this.busupdateform.get('updatedept').value;
    this.bus.arr = this.busupdateform.get('updatearr').value;
    this.bus.amount = this.busupdateform.get('updateamt').value;
    this.bus.currentEmptySeat = this.busupdateform.get('updateseat').value;
    this.busService.updateBus(this.bus).subscribe(
      data => {
        console.log(data);
        this.getBuses();
        this.isupdated = true;
      },
      error => console.log(error));
  }

  deleteBus(id:number){
    this.busService.deleteBus(id).subscribe(
      data => {
        this.message = data;
        this.deleteMessage = true;
        this.getBuses();
      },
      error => console.log(error));
  }

  changeisUpdate(){
    this.isupdated = false;
  }
}