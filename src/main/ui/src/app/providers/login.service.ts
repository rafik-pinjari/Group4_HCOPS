import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

@Injectable()
export class LoginService {
  private subUrl: string;
  constructor(private http: Http) { }

  login(logObj: any) {
    console.log("Login service called");
    this.subUrl='http://localhost:8080/login';
    let  obj = logObj.toString();
    console.log("Data in login Service : ", logObj);
    return  new  Promise((resolve, reject) => {
      this.http.post(this.subUrl, logObj).subscribe((res) => {
        
        resolve(res);
      },
        err => {
          reject(err);
          console.log("Data in error block :", logObj);
        });
    });
  }

}
