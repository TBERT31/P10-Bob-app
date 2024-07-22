package com.openclassrooms.bobapp.controller;

import com.openclassrooms.bobapp.model.Joke;
import com.openclassrooms.bobapp.service.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class JokeControllerTest {

    @Mock
    private JokeService jokeService;

    @InjectMocks
    private JokeController jokeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRandomJokes() {
        // Arrange
        Joke expectedJoke = new Joke("Que demande un footballeur à son coiffeur ?", "La coupe du monde s’il vous plait.");
        when(jokeService.getRandomJoke()).thenReturn(expectedJoke);

        // Act
        ResponseEntity<?> response = jokeController.getRandomJokes();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(expectedJoke);
    }
}
