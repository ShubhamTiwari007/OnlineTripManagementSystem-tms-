import { Customer } from "./Customer";

export class Feedback {
    id: number;
    description : string;
    rating : number;
    submitDate:Date;
    customer:Customer;
}