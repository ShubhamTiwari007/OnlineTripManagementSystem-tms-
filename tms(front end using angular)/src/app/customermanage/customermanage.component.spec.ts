import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomermanageComponent } from './customermanage.component';

describe('CustomermanageComponent', () => {
  let component: CustomermanageComponent;
  let fixture: ComponentFixture<CustomermanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomermanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomermanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
