import { TestBed } from '@angular/core/testing';

import { PackagebookingService } from './packagebooking.service';

describe('PackagebookingService', () => {
  let service: PackagebookingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PackagebookingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
