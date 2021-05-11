import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackagebookingpreviewComponent } from './packagebookingpreview.component';

describe('PackagebookingpreviewComponent', () => {
  let component: PackagebookingpreviewComponent;
  let fixture: ComponentFixture<PackagebookingpreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PackagebookingpreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PackagebookingpreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
