import { TestBed } from '@angular/core/testing';

import { RecomendationService } from './recomendation.service';

describe('ReccomendationService', () => {
  let service: RecomendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecomendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
