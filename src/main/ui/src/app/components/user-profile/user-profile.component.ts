import { Component, OnInit } from '@angular/core';
import { ProfilepicService } from '../../providers/profilepic.service';
import { HttpEventType, HttpResponse } from "@angular/common/http";
import { HttpXrsService } from './../../providers/http-xrs.service'; 


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  incidents: any;
 // ProfilepicService: any;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  constructor(public userprofile:ProfilepicService,private userGroupServe:HttpXrsService ) { }

  ngOnInit() {
    this.userGroupServe. httprequest({ type: 'GET', url: 'http://localhost:8080/profile/upload2/NMRD', json:{}})
.then((json :any) => {
console.log("user group component ",json);
this.incidents=json;
console.log("hjavhv",json);
}); 
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.userprofile.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });

    this.selectedFiles = undefined;
  }


}
