import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Signup } from '../model/Signup';
import { SignupService } from '../services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm:FormGroup

  name: string = ''
  mobileNo: string = ''
  address: string = ''
  email: string = ''
  username: string=''
  password: string = ''
  signup: Signup;
  signupdetail: Signup[] = [];


constructor(private signService: SignupService, private formBuilder: FormBuilder) {

   
  // validators used
  this.signupForm = this.formBuilder.group({
    cname: ['', Validators.required],
    cmobileNo: ['', Validators.required],
    caddress: ['', Validators.required],
    cemail: ['', [Validators.required, Validators.email]],
    cusername: ['', Validators.required],
    cpassword: ['', [Validators.required, Validators.min(6)]],
    cconfirmPassword: ['', [Validators.required, Validators.min(6)]]
  });
}
ngOnInit(): void {

}
// Function called when click on submit
onSubmit() {
  this.signup = new Signup(this.signupForm.get('cname').value, this.signupForm.get('cmobileNo').value, this.signupForm.get('caddress').value, this.signupForm.get('cemail').value, this.signupForm.get('cusername').value, this.signupForm.get('cpassword').value);
  // this.signup.name = this.signupForm.get('cname').value;
  // this.signup.mobileNo = this.signupForm.get('cmobileNo').value;
  // this.signup.address = this.signupForm.get('caddress').value;
  // this.signup.email = this.signupForm.get('cemail').value;
  // this.signup.username = this.signupForm.get('cusername').value;
  // this.signup.password = this.signupForm.get('cpassword').value;

  // let customer: Signup=new Signup(this.name, this.mobileNo,this.address,this.email, this.username, this.password);

  this.signService.addSignupDetail(this.signup).subscribe(
    
   data=>{
      console.log(data);
      this.name = '';
      this.mobileNo = '';
      this.address = '';
      this.email = '';
      this.username = '';
      this.password = '';
    },
    error => console.log(error));
}
}

