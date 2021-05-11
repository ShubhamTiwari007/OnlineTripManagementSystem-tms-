import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutemanageComponent } from './routemanage.component';

describe('RoutemanageComponent', () => {
  let component: RoutemanageComponent;
  let fixture: ComponentFixture<RoutemanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoutemanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoutemanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
