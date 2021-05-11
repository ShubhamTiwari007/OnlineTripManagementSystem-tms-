import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackagemanageComponent } from './packagemanage.component';

describe('PackagemanageComponent', () => {
  let component: PackagemanageComponent;
  let fixture: ComponentFixture<PackagemanageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PackagemanageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PackagemanageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
