import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { of } from 'rxjs';
import { AppComponent } from './app.component';
import {JokesService} from "./services/jokes.service";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import { Joke } from './model/joke.model';

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;
  let jokesService: jasmine.SpyObj<JokesService>;

  const mockJoke: Joke = { joke: 'Test joke', response: 'Test response' };

  beforeEach(async () => {
    const jokesServiceSpy = jasmine.createSpyObj('JokesService', ['getRandomJoke', 'joke$']);

    await TestBed.configureTestingModule({
      declarations: [AppComponent],
      imports: [
        MatToolbarModule,
        MatCardModule,
        MatDividerModule,
        MatButtonModule
      ],
      providers: [
        { provide: JokesService, useValue: jokesServiceSpy }
      ]
    }).compileComponents();

    jokesService = TestBed.inject(JokesService) as jasmine.SpyObj<JokesService>;
    jokesService.joke$.and.returnValue(of(mockJoke));

    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the app', () => {
    expect(component).toBeTruthy();
  });

  it('should call getRandomJoke on init', () => {
    expect(jokesService.getRandomJoke).toHaveBeenCalled();
  });

  it('should display the joke and response', () => {
    const jokeElement = fixture.debugElement.query(By.css('.joke')).nativeElement;
    const responseElement = fixture.debugElement.query(By.css('p:last-of-type')).nativeElement;

    expect(jokeElement.textContent).toContain(mockJoke.joke);
    expect(responseElement.textContent).toContain(mockJoke.response);
  });

  it('should call getRandomJoke when the button is clicked', () => {
    const button = fixture.debugElement.query(By.css('button')).nativeElement;
    button.click();

    expect(jokesService.getRandomJoke).toHaveBeenCalledTimes(2);
  });
});
