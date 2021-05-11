export class RouteData {
  from:string;
  to:string;
  date:Date;

  constructor(from, to, date) {
    this.from = from;
    this.to = to;
    this.date = date;
  }
}