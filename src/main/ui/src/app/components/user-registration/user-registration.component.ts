import { Component, OnInit } from '@angular/core';
// import{AddNewUserService} from '../../providers/add-new-user.service';
import { HttpXrsService } from '../../providers/http-xrs.service';
import { FormsModule} from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {

  gridData: any;
  cities = ['IN>Pune', 'IN>Banglore'];
  states = ['Maharashtra', 'Karnataka'];
  countries = ['India'];
  departments = ['HC OPS'];
  userGroups = ['HC OPS','Users'];

  user = {userId: '', email: '', city:this.cities[0], state:this.states[0],country:this.countries[0],department:this.departments[0],userGroup:this.userGroups[0]};

  constructor(public newuserserv:HttpXrsService) { }

  // userForm=new FormGroup({
  //   userId : new FormControl('',[Validators.required,Validators.minLength(4)])
  // });

    userForm:FormGroup;
  
  
    ngOnInit():void{
      this.userForm = new FormGroup({
        'userId': new FormControl(this.user.userId, [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(4),
        ]),
        'email': new FormControl(this.user.email, [
          Validators.required,
           Validators.pattern("^[A-Za-z]+.[^A-Za-z][^@]+@capco.com"),
          //  Validators.pattern("[^ @]*@[^ @]*")
        
        ]),
        'city': new FormControl(this.user.city, Validators.required),
        'state': new FormControl(this.user.state, Validators.required),
        'country': new FormControl(this.user.country, Validators.required),
        'department': new FormControl(this.user.department, Validators.required),
        'userGroup': new FormControl(this.user.userGroup, Validators.required),
       
      });
    }
    saveAddNewUserForm(){
      let user={
        userIdservevr:this.userId.value,
        useremailservevar:this.email.value,
        cityservevar:this.city.value,
        stateservevar:this.state.value,
        countryservevar:this.country.value,
        deptservevar:this.department.value,
        usergroupservevar:this.userGroup.value,

      }
      console.log(user);    
      // this.newuserserv.httprequest(user).then((res)  =>  {
      //   if(res){
      //     console.log("res :",res);          
      //     console.log("Registration sucessfull")
      //   }
      //   else{
      //     console.log("Registration Unsucessfull");
      //   }
      // console.log(res);
      // })
      this.newuserserv.httprequest({ type: 'POST', url: './assets/data/group.json',data:{}})
      .then((data:any) => {
        console.log("user group component ",data.groups);
        this.gridData = data.groups;
      });

 
    }
    get userId() { return this.userForm.get('userId'); }
    get email() { return this.userForm.get('email'); }
    get city() { return this.userForm.get('city'); }
    get state() { return this.userForm.get('state'); }
    get country() { return this.userForm.get('country'); }
    get department() { return this.userForm.get('department'); }
    get userGroup() { return this.userForm.get('userGroup'); }

}
