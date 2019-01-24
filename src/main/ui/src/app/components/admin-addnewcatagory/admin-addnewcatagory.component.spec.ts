import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddnewcatagoryComponent } from './admin-addnewcatagory.component';

describe('AdminAddnewcatagoryComponent', () => {
  let component: AdminAddnewcatagoryComponent;
  let fixture: ComponentFixture<AdminAddnewcatagoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddnewcatagoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddnewcatagoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
