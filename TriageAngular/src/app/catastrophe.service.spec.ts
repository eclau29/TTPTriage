import { TestBed } from '@angular/core/testing';

import { CatastropheService } from './catastrophe.service';

describe('CatastropheService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatastropheService = TestBed.get(CatastropheService);
    expect(service).toBeTruthy();
  });
});
