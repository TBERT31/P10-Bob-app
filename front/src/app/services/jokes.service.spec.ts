import { TestBed } from '@angular/core/testing';

import { JokesService } from './jokes.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('JokesService', () => {
  let service: JokesService;

  beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [JokesService]
      });
      service = TestBed.get(JokesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

});
