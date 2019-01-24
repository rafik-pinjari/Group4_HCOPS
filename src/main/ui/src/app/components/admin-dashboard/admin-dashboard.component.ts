import { Component, OnInit } from '@angular/core';
import { customers } from '../../../customers';
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {

    public gridData: any[] = customers;

public pieData: any = [
    { category: 'Pune', value: 0.42 },
    { category: 'Bangalor', value: 0.58 }
  ]
public events: string[] = [];
      public series: any[] = [{
              name: 'Pune',
              data: [20,40,10,30,40,30,20,10,5,20,30,5]
          }, {
              name: 'Bangalore',
              data: [30,40,50,10,20,30,25,15,61,27,20,30]
          }];
  
      public categories:any = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "July","Aug", "Sept", "Oct","Nov","Dec"];
  
      public onRender(): void {
          this.log('render');
      }
  
      public onAxisLabelClick(e): void {
          this.log('axisLabelClick', e);
      }
  
      public onLegendItemClick(e): void {
          this.log('legendItemClick', e);
      }
  
      public onLegendItemHover(e): void {
          this.log('legendItemHover', e);
      }
  
      public onPlotAreaClick(e): void {
          this.log('plotAreaClick', e);
      }
  
      public onPlotAreaHover(e): void {
          this.log('plotAreaHover', e);
      }
  
      public onSeriesClick(e): void {
          this.log('seriesClick', e);
      }
  
      public onSeriesHover(e): void {
          this.log('seriesHover', e);
      }
  
      private log(event: string, arg: any = null): void {
          this.events.push(`${event}`);
          console.log(arg);
      }


  constructor() { 
      
  }

  ngOnInit() {
  
  }

}
