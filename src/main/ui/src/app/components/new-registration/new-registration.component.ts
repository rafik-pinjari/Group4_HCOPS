import { FormsModule} from '@angular/forms';
import{RegisterService} from '../../providers/register.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-registration',
  templateUrl: './new-registration.component.html',
  styleUrls: ['./new-registration.component.scss']
})
export class NewRegistrationComponent implements OnInit { 
 
  register: any;
  username: string;
  userid:string;
  password:any;
  email:string;
  constructor(public registerUsr:RegisterService,public router:Router) {
  }
  
  
  user = {userName: '', userId: '', emailId:'', pass: '', confirmPassword:''};
  registrationForm: FormGroup;
  ngOnInit():void{

    this.registrationForm = new FormGroup({
      'userName': new FormControl(this.user.userName, [
        Validators.required,
        Validators.pattern("[a-zA-Z ]*")
      ]),

      'userId': new FormControl(this.user.userId, [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(4), 
        Validators.pattern("^[a-zA-Z]*$")
      ]),
      'emailId': new FormControl(this.user.emailId, [
        Validators.required,
         Validators.pattern("^[A-Za-z]+.[^A-Za-z][^@]+@capco.com"),
      ]),
      'pass': new FormControl(this.user.pass, [
        Validators.required,
        Validators.minLength(8),       
      ]),
      'confirmPassword': new FormControl(this.user.confirmPassword, [
        Validators.required,
        Validators.minLength(8),       
      ]),
      
    
    });
  }

  get userName() { return this.registrationForm.get('userName'); }
  get userId() { return this.registrationForm.get('userId'); }
  get emailId() { return this.registrationForm.get('emailId'); }
  get pass() { return this.registrationForm.get('pass'); }
  get confirmPassword() { return this.registrationForm.get('confirmPassword'); }
  

  registerfn() {
    let body = {
    username: this.username,
    userid:this.userid,
    password:this.password,
    email:this.email    
    }    
    console.log(body);    
    this.registerUsr.register1(body).then((res) => {
      if(res){
        console.log("res :",res);
        this.router.navigate(['/user-login']);
        console.log("Registration sucessfull")
      }
      else{
        console.log("Registration Unsucessfull");
      }
    console.log(res);
    })
    } 
    
    
    
}
