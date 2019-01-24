import { Component, OnInit } from '@angular/core';
import { customers } from '../../../customers';
@Component({
  selector: 'app-resolved',
  templateUrl: './resolved.component.html',
  styleUrls: ['./resolved.component.scss']
})
export class ResolvedComponent implements OnInit {
  public gridData: any[] = customers;
  constructor() { }

  ngOnInit() {
  }

}
