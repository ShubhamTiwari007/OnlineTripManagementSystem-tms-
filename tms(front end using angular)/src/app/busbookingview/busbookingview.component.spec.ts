import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusbookingviewComponent } from './busbookingview.component';

describe('BusbookingviewComponent', () => {
  let component: BusbookingviewComponent;
  let fixture: ComponentFixture<BusbookingviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusbookingviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusbookingviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
