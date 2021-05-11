import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DataTablesModule } from "angular-datatables";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { BusviewComponent } from './busview/busview.component';
import { HotelviewComponent } from './hotelview/hotelview.component';
import { PackageviewComponent } from './packageview/packageview.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BusdetailComponent } from './busdetail/busdetail.component';
import { RoutedetailComponent } from './routedetail/routedetail.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { ContactComponent } from './contact/contact.component'
import { HotelService } from './services/hotel.service';
import { PackageService } from './services/package.service';
import { FooterComponent } from './footer/footer.component';
import { MatIconModule } from '@angular/material/icon';
import { CustomerprofileComponent } from './customerprofile/customerprofile.component';
import { BusbookingviewComponent } from './busbookingview/busbookingview.component';
import { MybusbookingComponent } from './mybusbooking/mybusbooking.component';
import { MyhotelbookingComponent } from './myhotelbooking/myhotelbooking.component';
import { MypackagebookingComponent } from './mypackagebooking/mypackagebooking.component';
import { HotelbookingviewComponent } from './hotelbookingview/hotelbookingview.component'
import { BusbookingService } from './services/busbooking.service';
import { RouteService } from './services/route.service';
import { DatePipe } from '@angular/common';
import { StationService } from './services/station.service';
import { PackagebookingviewComponent } from './packagebookingview/packagebookingview.component';
import { PackagebookingpreviewComponent } from './packagebookingpreview/packagebookingpreview.component';
import { BusmanageComponent } from './busmanage/busmanage.component';
import { HotelmanageComponent } from './hotelmanage/hotelmanage.component';
import { RoutemanageComponent } from './routemanage/routemanage.component';
import { StationmanageComponent } from './stationmanage/stationmanage.component';
import { MatRadioModule } from '@angular/material/radio';
import { LoginService } from './services/login.service';
import { CustomermanageComponent } from './customermanage/customermanage.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { PackagemanageComponent } from './packagemanage/packagemanage.component';
import {MatSelectModule} from '@angular/material/select'


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    BusviewComponent,
    HotelviewComponent,
    PackageviewComponent,
    LoginComponent,
    SignupComponent,
    BusdetailComponent,
    RoutedetailComponent,
    ContactComponent,
    FooterComponent,
    CustomerprofileComponent,
    BusbookingviewComponent,
    MybusbookingComponent,
    MyhotelbookingComponent,
    MypackagebookingComponent,
    HotelbookingviewComponent,
    PackagebookingviewComponent,
    PackagebookingpreviewComponent,
    BusmanageComponent,
    HotelmanageComponent,
    RoutemanageComponent,
    StationmanageComponent,
    CustomermanageComponent,
    FeedbackComponent,
    PackagemanageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    DataTablesModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatAutocompleteModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule,
    MatIconModule,
    MatRadioModule,
	MatSelectModule
  ],
  providers: [
    HotelService,
    PackageService,
    BusbookingService,
    RouteService,
    StationService,
    DatePipe,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
