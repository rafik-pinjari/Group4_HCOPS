import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserIncidentFormService } from '../../providers/user-incident-form.service';
import { CategoryserviceService } from '../../providers/categoryservice.service';
@Component({
  selector: 'app-user-incident-form',
  templateUrl: './user-incident-form.component.html',
  styleUrls: ['./user-incident-form.component.scss']
})
export class UserIncidentFormComponent implements OnInit {
  UserIncidentFormService: any;
  requestor: string;
  location: string;
  category: string;
  subcategory: string;
  sub=[];
  cat: any;
  Subcategories = [];
  categories=[];
  name:any;
  constructor(public userincidentdetails: UserIncidentFormService,private categoryservice:CategoryserviceService) { }

  locationname=["In>Pune","In>Banglore"]
  ngOnInit() {
    this.categoryservice.getJSONDataAsync("assets/data/categories.json").then(data => {
      this.setQueryOptionsData(data);
      console.log(data)
    }) 
  }

  setQueryOptionsData(data: any) {
    this.categories=data.categories;
    this.name = data.name;
    this.Subcategories = data.Subcategories;
    }
    setOptions(){
      for(let i=0;i<this.categories.length;i++){
        if(this.categories[i].name==this.cat){
          this.sub=this.categories[i].Subcategories;
        }
      }
    }

   getdetails() {
    let  data  =  {
      requestor:  this.requestor,
      location: this.location,
      
      //confirm_password:this.confirm_password,
     
    }

    console.log(data);
    this.userincidentdetails.getincidentdetails(data).then((res) => {
      console.log(res);
    }, err => {
      console.log(err);
    })
  }

}
