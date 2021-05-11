import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelbookingviewComponent } from './hotelbookingview.component';

describe('HotelbookingviewComponent', () => {
  let component: HotelbookingviewComponent;
  let fixture: ComponentFixture<HotelbookingviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelbookingviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelbookingviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
