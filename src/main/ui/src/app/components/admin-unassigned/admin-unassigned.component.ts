import { Component, OnInit } from '@angular/core';
import { constant } from '@progress/kendo-data-query/dist/npm/funcs';
import { customers } from '../../../customers';
import { EditServiceService } from '../../providers/edit-service.service';
import { GridDataResult } from '@progress/kendo-angular-grid';
@Component({
  selector: 'app-admin-unassigned',
  templateUrl: './admin-unassigned.component.html',
  styleUrls: ['./admin-unassigned.component.scss']
})
export class AdminUnassignedComponent implements OnInit {
  public gridData: any[] = customers;
  public sss: String;
  public listItems: Array<string> = [
    'Joe Joel', 'Anne Joe', 'Hammer Hell', 'Rocky Venis',
    'Anchor Due', 'Sanna Thomas'
];
  constructor(private es: EditServiceService) {
   }

   ngOnInit() {
    // this.view = this.editService.pipe(map(data => process(data, this.gridState)));

    // this.editService.read();
  }
  // removeRecord(){
  //   if(checkbox.checked==true){}
  // }
  public removeHandler({dataItem}) {
    this.es.remove(dataItem);
}
assignedItems(dataItem) {
  dataItem.AssignedTo = this.sss;
  console.log(dataItem);
  console.log(this.es.assignedRow);
    this.es.assignedRow.push(dataItem);
    console.log('after', this.es.assignedRow);
}

removeItems() {
  let c = 0;
  for (let i = 0; i < this.gridData.length; i++) {
    for (let j = 0; j < this.es.assignedRow.length; j++) {
      if (this.es.assignedRow[j] == this.gridData[i]) {
        c++;
        this.es.assignedRow[j].AssignedTo = this.sss;
        this.gridData.splice(i, 1);
      }
    }
  }
  console.log('gridData ', this.gridData);
  console.log('after removal', this.es.assignedRow);
}

}
