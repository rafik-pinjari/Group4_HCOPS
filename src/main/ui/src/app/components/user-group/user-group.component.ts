import { groups } from './../../../groups';
import { Component, OnInit } from '@angular/core';
import { HttpXrsService } from '../../providers/http-xrs.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Rx';
@Component({
  selector: 'user-group',
  templateUrl: './user-group.component.html',
  styleUrls: ['./user-group.component.scss']
})
export class UserGroupComponent implements OnInit {
  public gridData: any;
  constructor(public userGroupServe: HttpXrsService, public router: Router) { }
  userGroup = {grpcode:'',grpname:''};
  ngOnInit() {
    /**
   * @param type endpoint for which we get the json data
   */
    this.userGroupServe.httprequest({ type: 'GET', url: './assets/data/group.json',json:{}})
      .then((json:any) => {
        console.log("user group component ",json);
        this.gridData = json
      });
  }

}
