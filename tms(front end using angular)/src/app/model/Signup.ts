export class Signup {
    id:number
    username:string
    password:string
    name:string
    address:string
    mobileNo:string
    email:string
    constructor(name: string, mobileNo : string,address : string, email: string, username: string, password: string ){
        this.name=name;
        this.mobileNo=mobileNo;
        this.address=address;
        this.email=email;
        this.username=username;
        this.password=password;
    }

}