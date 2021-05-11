import { Customer } from "./Customer";
import { Hotel } from "./Hotel";
import { Package } from "./Package";

export class PackageBooking {

    id:number;
    customer:Customer;
    bookingDate:Date;
    noOfCustomers:number;
    amount:number;
    description:string;
    plannedDate:Date;

    hotel:Hotel;
    packages:Package;

    constructor(customer:Customer, bookingDate:Date, noOfCustomers:number, amount:number, description:string, plannedDate:Date, hotel:Hotel, packages:Package) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.noOfCustomers = noOfCustomers;
        this.amount = amount;
        this.description = description;
        this.plannedDate = plannedDate;
        this.hotel = hotel;
        this.packages = packages;
    }
}