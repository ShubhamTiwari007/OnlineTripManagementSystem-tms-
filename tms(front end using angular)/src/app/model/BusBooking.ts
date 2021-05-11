import { Bus } from "./Bus";
import { Customer } from "./Customer";
import { Station } from "./Station";

export class BusBooking {
    id: number;
    noOfPass: number;
    amount: number;
    bookingDate: Date;
    journeyDate: string;
    dep: string;
    arr: string;
    customer: Customer;
    from: Station;
    to: Station;
    bus: Bus;

    constructor(noOfPass: number, amount: number, bookingDate: Date, journeyDate: string, dep: string, arr: string, customer: Customer, from: Station, to: Station, bus: Bus) {
     
        this.noOfPass = noOfPass;
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.journeyDate = journeyDate;
        this.dep = dep;
        this.arr = arr;
        this.customer = customer;
        this.from = from;
        this.to = to;
        this.bus = bus;
    }
}