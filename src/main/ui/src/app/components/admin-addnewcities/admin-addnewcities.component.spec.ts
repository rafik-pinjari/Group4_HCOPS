import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddnewcitiesComponent } from './admin-addnewcities.component';

describe('AdminAddnewcitiesComponent', () => {
  let component: AdminAddnewcitiesComponent;
  let fixture: ComponentFixture<AdminAddnewcitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddnewcitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddnewcitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
