import { TestBed } from '@angular/core/testing';

import { CustomerTypeServiceService } from './customer-type-service.service';

describe('CustomerTypeServiceService', () => {
  let service: CustomerTypeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerTypeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
