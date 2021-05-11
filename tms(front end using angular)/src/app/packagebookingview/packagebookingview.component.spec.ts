import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackagebookingviewComponent } from './packagebookingview.component';

describe('PackagebookingviewComponent', () => {
  let component: PackagebookingviewComponent;
  let fixture: ComponentFixture<PackagebookingviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PackagebookingviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PackagebookingviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
