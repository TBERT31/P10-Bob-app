import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { JokesService } from './jokes.service';
import { Joke } from '../model/joke.model';

describe('JokesService', () => {
  let service: JokesService;
  let httpMock: HttpTestingController;

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
  });

  it('should call getRandomJoke on service creation', () => {
    const mockJoke: Joke = { joke: 'Test joke', response: 'Test response' };
    const request = httpMock.expectOne('api/joke');
    request.flush(mockJoke);

    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });
  });

  it('getRandomJoke should make an HTTP GET request and update the subject', () => {
    const mockJoke: Joke = { joke: 'Test joke', response: 'Test response' };

    service.getRandomJoke();
    const request = httpMock.expectOne('api/joke');
    expect(request.request.method).toBe('GET');
    request.flush(mockJoke);

    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });
  });

  it('joke$ should return the current value of the subject', () => {
    const mockJoke: Joke = { joke: 'Test joke', response: 'Test response' };
    service['subject'].next(mockJoke);

    service.joke$().subscribe(joke => {
      expect(joke).toEqual(mockJoke);
    });
  });
});
