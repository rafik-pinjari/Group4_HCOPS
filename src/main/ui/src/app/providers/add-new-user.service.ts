import { Injectable } from '@angular/core';
import{Http, Response, RequestOptions, Headers} from '@angular/http';


@Injectable()
export class AddNewUserService {
  private subUrl:string;
  constructor(private http: Http) { }
  saveAddNewUserForm(user:any){
    console.log("Add new user service called");
    
      return new Promise((resolve,reject)=>{
      this.http.post(this.subUrl,user).subscribe((res)=>{
      console.log("Data ",res);
      resolve(res);       
      },

      err=>{reject(err);
        console.log("Data ",user);
      });
    });
    
  }
}
