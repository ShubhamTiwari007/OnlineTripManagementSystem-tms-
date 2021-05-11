import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MypackagebookingComponent } from './mypackagebooking.component';

describe('MypackagebookingComponent', () => {
  let component: MypackagebookingComponent;
  let fixture: ComponentFixture<MypackagebookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MypackagebookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MypackagebookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
