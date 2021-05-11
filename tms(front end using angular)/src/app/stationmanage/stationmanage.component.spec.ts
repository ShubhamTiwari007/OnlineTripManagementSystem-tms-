import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StationmanageComponent } from './stationmanage.component';

describe('StationmanageComponent', () => {
  let component: StationmanageComponent;
  let fixture: ComponentFixture<StationmanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StationmanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StationmanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
