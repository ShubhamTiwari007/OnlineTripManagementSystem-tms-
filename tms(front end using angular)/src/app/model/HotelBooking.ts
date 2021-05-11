import { Customer } from "./Customer";
import { Hotel } from "./Hotel";

export class HotelBooking {
    id:number;
    bookingDate:Date;
    noOfCustomer:number;
    amount:number;
    description:string;
    duration:string;
    checkin:any;
    checkOut:any;
    customer:Customer;
    hotel:Hotel;

    constructor(noOfCustomer:number, amount:number, description:string, duration:string, checkin:any, checkOut:any, customer:Customer, hotel:Hotel) {
        this.noOfCustomer = noOfCustomer;
        this.amount = amount;
        this.description = description;
        this.duration = duration;
        this.checkin = checkin;
        this.checkOut = checkOut;
        this.customer = customer;
        this.hotel = hotel;
    }
}