import { Hotel } from "./Hotel";

export class Package {

    id:number;
    name:string;
    destination:string;
    duration:string;
	description:string;
	price:number;
    hotels:Hotel[];
}