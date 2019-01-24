import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { UserincidentlistService } from "../../providers/userincidentlist.service";

@Component({
  selector: 'app-user-incidentlist',
  templateUrl: './user-incidentlist.component.html',
  styleUrls: ['./user-incidentlist.component.scss']
})
export class UserIncidentlistComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private usrincident:UserincidentlistService) { }

  ngOnInit() {
    this.usrincident.getincidentlist();
  }



}
