package com.openclassrooms.bobapp.service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class JokeServiceTest {

    @Mock
    private JsonReader jsonReader;

    @InjectMocks
    private JokeService jokeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRandomJoke() {
        // Given
        Joke joke1 = new Joke("C'est l'histoire du ptit dej, tu la connais ?", "Pas de bol.");
        Joke joke2 = new Joke("C'est l'histoire d'une blague vaseuse.", "Mets tes bottes.");
        List<Joke> jokes = Arrays.asList(joke1, joke2);

        // Mocking the behavior of jsonReader to return the predefined list of jokes
        when(jsonReader.getJokes()).thenReturn(jokes);

        // When
        Joke randomJoke = jokeService.getRandomJoke();

        // Then
        // Verify that the result is one of the jokes in the list
        assertThat(jokes).contains(randomJoke);
    }
}
