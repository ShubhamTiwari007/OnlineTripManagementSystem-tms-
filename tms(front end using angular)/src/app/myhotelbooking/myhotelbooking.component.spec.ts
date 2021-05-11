import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyhotelbookingComponent } from './myhotelbooking.component';

describe('MyhotelbookingComponent', () => {
  let component: MyhotelbookingComponent;
  let fixture: ComponentFixture<MyhotelbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyhotelbookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyhotelbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
