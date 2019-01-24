import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-incidentform-reopen',
  templateUrl: './user-incidentform-reopen.component.html',
  styleUrls: ['./user-incidentform-reopen.component.scss']
})
export class UserIncidentformReopenComponent implements OnInit {

  cities = ['IN>Pune', 'IN>Banglore'];

  user = {incidentNo: '', state: '', city:'',category:'',subCategory:'',description:'',solution:''};

  constructor() { }

  reopenForm: FormGroup;
  ngOnInit():void{
    this.reopenForm = new FormGroup({
      'city': new FormControl(this.user.city, Validators.required),
      'category': new FormControl(this.user.category, Validators.required),
      'subCategory': new FormControl(this.user.subCategory, Validators.required),
      'description': new FormControl(this.user.description, Validators.required),
      'solution': new FormControl(this.user.solution, Validators.required),
    
    });
  }

  get city() { return this.reopenForm.get('city'); }
  get category() { return this.reopenForm.get('category'); }
  get subCategory() { return this.reopenForm.get('subCategory'); }
  get description() { return this.reopenForm.get('description'); }
  get solution() { return this.reopenForm.get('solution'); }
  

}
