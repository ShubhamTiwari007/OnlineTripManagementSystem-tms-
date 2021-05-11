import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusmanageComponent } from './busmanage.component';

describe('BusmanageComponent', () => {
  let component: BusmanageComponent;
  let fixture: ComponentFixture<BusmanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusmanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusmanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
