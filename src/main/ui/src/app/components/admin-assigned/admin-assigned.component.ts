import { Component, OnInit } from '@angular/core';
import { customers } from '../../../customers';
import { EditServiceService } from '../../providers/edit-service.service';
import { log } from 'util';
@Component({
  selector: 'app-admin-assigned',
  templateUrl: './admin-assigned.component.html',
  styleUrls: ['./admin-assigned.component.scss']
})
export class AdminAssignedComponent implements OnInit {
  public assignedData: any[];
  public gridData: any[] = customers;
  constructor(private es: EditServiceService) { this.assignedData = this.es.assignedRow; }

  ngOnInit() {
    console.log(this.assignedData);
  }

}
