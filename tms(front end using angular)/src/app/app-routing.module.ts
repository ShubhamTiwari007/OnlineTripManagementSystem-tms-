import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusbookingviewComponent } from './busbookingview/busbookingview.component';
import { BusdetailComponent } from './busdetail/busdetail.component';
import { BusmanageComponent } from './busmanage/busmanage.component';
import { BusviewComponent } from './busview/busview.component';
import { ContactComponent } from './contact/contact.component';
import { CustomerprofileComponent } from './customerprofile/customerprofile.component';
import { HomeComponent } from './home/home.component';
import { HotelbookingviewComponent } from './hotelbookingview/hotelbookingview.component';
import { HotelmanageComponent } from './hotelmanage/hotelmanage.component';
import { HotelviewComponent } from './hotelview/hotelview.component';
import { LoginComponent } from './login/login.component';
import { Feedback } from './model/Feedback';
import { MybusbookingComponent } from './mybusbooking/mybusbooking.component';
import { MyhotelbookingComponent } from './myhotelbooking/myhotelbooking.component';
import { MypackagebookingComponent } from './mypackagebooking/mypackagebooking.component';
import { PackagebookingpreviewComponent } from './packagebookingpreview/packagebookingpreview.component';
import { PackagebookingviewComponent } from './packagebookingview/packagebookingview.component';
import { PackageviewComponent } from './packageview/packageview.component';
import { RoutedetailComponent } from './routedetail/routedetail.component';
import { RoutemanageComponent } from './routemanage/routemanage.component';
import { SignupComponent } from './signup/signup.component';
import { StationmanageComponent } from './stationmanage/stationmanage.component';
import {PackagemanageComponent} from './packagemanage/packagemanage.component'

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'bus', component: BusviewComponent },
  { path: 'hotel', component: HotelviewComponent },
  { path: 'package', component: PackageviewComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'routedetail', component: RoutedetailComponent },
  { path: 'busdetail', component: BusdetailComponent },
  { path: 'myprofile', component: CustomerprofileComponent },
  { path: 'busbookingview', component: BusbookingviewComponent },
  { path: 'mybusbooking', component: MybusbookingComponent },
  { path: 'myhotelbooking', component: MyhotelbookingComponent },
  { path: 'mypackagebooking', component: MypackagebookingComponent },
  { path: 'hotelbookingview', component: HotelbookingviewComponent },
  { path: 'packagebookingview', component: PackagebookingviewComponent },
  { path: 'packagebookingpreview', component: PackagebookingpreviewComponent },
  { path: 'busmanage', component: BusmanageComponent },
  { path: 'hotelmanage', component: HotelmanageComponent },
  { path: 'routemanage', component: RoutemanageComponent },
  { path: 'stationmanage', component: StationmanageComponent },
  { path: 'feedback', component: Feedback },
    { path: 'packagemanage', component: PackagemanageComponent }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
