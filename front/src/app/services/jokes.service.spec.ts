import { TestBed } from '@angular/core/testing';
import { JokesService } from './jokes.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Joke } from '../model/joke.model';

describe('JokesService', () => {
  let service: JokesService;
  let httpMock: HttpTestingController;

  const mockJoke: Joke = { joke: 'Test joke', response: 'Test response' };

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [JokesService]
    });
    service = TestBed.get(JokesService);
    httpMock = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
    const request = httpMock.expectOne('api/joke');
    request.flush(mockJoke);
  });

  it('should call getRandomJoke on service creation', () => {
    const request = httpMock.expectOne('api/joke');
    request.flush(mockJoke);

    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });
  });

  it('getRandomJoke should make an HTTP GET request and update the subject', () => {
    httpMock.expectOne('api/joke').flush(mockJoke);

    service.getRandomJoke();
    const request = httpMock.expectOne('api/joke');
    expect(request.request.method).toBe('GET');
    request.flush(mockJoke);

    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });
  });

  it('joke$ should return the current value of the subject', () => {
    service['subject'].next(mockJoke);
    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });

    const request = httpMock.expectOne('api/joke');
    request.flush(mockJoke);
  });
});
