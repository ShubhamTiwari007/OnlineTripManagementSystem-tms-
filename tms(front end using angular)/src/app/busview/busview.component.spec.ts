import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusviewComponent } from './busview.component';

describe('BusviewComponent', () => {
  let component: BusviewComponent;
  let fixture: ComponentFixture<BusviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
