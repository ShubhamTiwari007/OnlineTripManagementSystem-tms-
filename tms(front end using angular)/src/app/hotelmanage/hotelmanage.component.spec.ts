import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelmanageComponent } from './hotelmanage.component';

describe('HotelmanageComponent', () => {
  let component: HotelmanageComponent;
  let fixture: ComponentFixture<HotelmanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelmanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelmanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
