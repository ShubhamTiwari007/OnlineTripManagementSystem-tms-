import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MybusbookingComponent } from './mybusbooking.component';

describe('MybusbookingComponent', () => {
  let component: MybusbookingComponent;
  let fixture: ComponentFixture<MybusbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MybusbookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MybusbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
