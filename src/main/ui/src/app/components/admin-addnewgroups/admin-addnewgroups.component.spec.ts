import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddnewgroupsComponent } from './admin-addnewgroups.component';

describe('AdminAddnewgroupsComponent', () => {
  let component: AdminAddnewgroupsComponent;
  let fixture: ComponentFixture<AdminAddnewgroupsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddnewgroupsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddnewgroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
