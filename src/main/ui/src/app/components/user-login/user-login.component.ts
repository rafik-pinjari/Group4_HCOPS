import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../providers/login.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProfilepicService } from "../../providers/profilepic.service";



@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  login: any;
  userid: string;
  pass: any;

  user = {userId: '', password: ''};
  constructor(public loginServe: LoginService, public router: Router,private usrservice: ProfilepicService) { }

  loginForm: FormGroup;
  ngOnInit():void{
    this.loginForm = new FormGroup({
      'userId': new FormControl(this.user.userId, [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(4),
        Validators.pattern("^[a-zA-Z]*$")
      ]),
      'password': new FormControl(this.user.password, [
        Validators.required,
        Validators.minLength(8),       
           
      ]),
    
    });
  }

  get userId() { return this.loginForm.get('userId'); }
  get password() { return this.loginForm.get('password'); }


  loginfn() {
    let logObj = {
      userid: this.userid,
      pass: this.pass
    }
    console.log(logObj);
   
    this.loginServe.login(logObj).then((res) => {
      if(res){
        console.log("res :",res);
        this.router.navigate(['/main']);
        console.log("login sucessfull")
      }
      else{
        console.log("Invalid User");
      }

    });

  }

}
