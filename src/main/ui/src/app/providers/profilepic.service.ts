import { Injectable } from '@angular/core';
import{Http, Response, RequestOptions, Headers} from '@angular/http';
import { Observable } from "rxjs/Observable";
import { HttpClient, HttpEvent, HttpRequest } from "@angular/common/http";

@Injectable()
export class ProfilepicService {
 
  constructor(private http: HttpClient) { }
  
    pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
      const formdata: FormData = new FormData();
  
      formdata.append('file', file);
      console.log("file pppp",file);
  
      const req = new HttpRequest('POST','http://localhost:8080/profile/upload1', formdata, {
        reportProgress: true,
        responseType: 'text'
      });
  
      return this.http.request(req);
    }
  
//     getFiles(): Observable<any> {
//       return this.http.get('http://localhost:8080/profile/upload2/answ');
//       // console.log();
//     }

    // getincidentlist(){
      
    //   console.log("User incident  service called");
    //   this.subUrl='assets/data/incidents.json';  
    //   // let obj=data.toString();
    //   // //console.log("Data ",body);
    //   return new Promise((resolve,reject)=>{
    //     this.http.get(this.subUrl).subscribe((res)=>{
    //       console.log(res);
    //      resolve(res);
    //   },
    //     err=>{reject(err);
    //       reject(err);
    //     });
    //   });
    // }
  
}
