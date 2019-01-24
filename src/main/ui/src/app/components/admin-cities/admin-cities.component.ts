import { Component, OnInit } from '@angular/core';
import { location } from '../../../cities';
import { LocationserviceService } from '../../providers/locationservice.service';
@Component({
  selector: 'app-admin-cities',
  templateUrl: './admin-cities.component.html',
  styleUrls: ['./admin-cities.component.scss']
})
export class AdminCitiesComponent implements OnInit {
    cit: any;
    st: any;
    cunt :any;
    cnt : any;
    locations=[];
   country :any;
    states = [];
    cities = [];
    state: any;
    constructor(private locationservice: LocationserviceService) { }
  
    ngOnInit() {
      this.locationservice.getJSONDataAsync("assets/data/locations.json").then(data => {
        this.setQueryOptionsData(data);
        console.log(data)
      })
    }
    setQueryOptionsData(data: any) {
      this.locations=data.locations;
      this.country = data.country;
      this.states = data.states;
      this.state = data.state;
      this.cities = data.cities;
  
    }
    setOptions(){
      for (let i = 0; i < this.locations.length; i++) { 
    if (this.locations[i].country == this.cnt) {
             this.cunt = this.locations[i].states;
            for (let z = 0; z < this.cunt.length; z++) {
            if (this.cunt[z].state == this.st) {
              this.cit = this.cunt[z].cities;
            }
          }
  
        }
      }
    }
  
  

}
