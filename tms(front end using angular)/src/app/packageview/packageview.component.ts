import { Component, OnInit } from '@angular/core';
import { Package } from '../model/Package';
import { PackageService } from '../services/package.service';

@Component({
  selector: 'app-packageview',
  templateUrl: './packageview.component.html',
  styleUrls: ['./packageview.component.css']
})
export class PackageviewComponent implements OnInit {

  constructor(private packageService:PackageService) { }

  packages:Package[];

  ngOnInit(): void {
    this.getPackages();
  }
​​​​​​​ 
  getPackages() {
    this.packageService.getPackage().subscribe(
      data => {
        this.packages = data;        
      },
      error => {
        console.log(error);
      }
    )
  }

  onSelectPackage(id:number) {
    this.packageService.selectedPackageId = id;
    console.log(id);
  }

}
