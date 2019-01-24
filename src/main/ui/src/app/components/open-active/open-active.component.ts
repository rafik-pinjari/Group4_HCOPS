import { Component, OnInit } from '@angular/core';
import { customers } from '../../../customers';
@Component({
  selector: 'app-open-active',
  templateUrl: './open-active.component.html',
  styleUrls: ['./open-active.component.scss']
})
export class OpenActiveComponent implements OnInit {
  public gridData: any[] = customers;
  constructor() { }

  ngOnInit() {
  }

}
