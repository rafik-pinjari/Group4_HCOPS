import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
// import 'rxjs/add/observable/catch';

import { Observable } from 'rxjs/Observable';
// import 'rxjs/Rx';
@Injectable()
export class UserGroupService {
  public BASE_URL: string = "";

  constructor(public http: Http) { }
  userGroupData(req) {
    let xhr: any;
    return new Promise((resolve, reject) => {
      try {
     
        switch (req.type) {
          case 'GET':
            console.log('get')
            this.http.get(this.BASE_URL + req.url).subscribe((data) => {
              // console.log("user group service ",data);
              if (data.status == 200 && data.statusText == "OK") {
                let json =data.json();
                resolve(json);
                console.log("user group service ok ",json);
              } else {
                throw data;
              }
            },
              error => {
                throw error;
              });
            break;
          case 'POST':
            this.http.post(this.BASE_URL + req.url, req.data).subscribe((data) => {
              if (data.status == 200 && data.statusText == "OK") {
                // let json = data.json();
                // resolve(json);
              } else {
                throw data;
              }
            },
              error => {
                throw error;
              });
            break;
          default:
            break;
        }
      } catch (error) {
        console.log(error);
      }
    });
  }

  get(url) {
    return new Promise((resolve, reject) => {

      this.http.get(url).subscribe((data) => {
        resolve(data)
      }, err => {
        reject(err);
      })

    })
  }
}

