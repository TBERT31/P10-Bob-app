package com.openclassrooms.bobapp.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JokeTest {

    @Test
    void testJokeConstructorAndGetters() {
        // Given
        String expectedJoke = "Why did the scarecrow win an award?";
        String expectedResponse = "Because he was outstanding in his field.";

        // When
        Joke joke = new Joke(expectedJoke, expectedResponse);

        // Then
        assertThat(joke.getJoke()).isEqualTo(expectedJoke);
        assertThat(joke.getResponse()).isEqualTo(expectedResponse);
    }

    @Test
    void testJokeSetters() {
        // Given
        Joke joke = new Joke();
        String newJoke = "Pourquoi les Belges viennent-ils à la messe avec du savon ?";
        String newResponse = "Pour l’Ave Maria..";

        // When
        joke.setJoke(newJoke);
        joke.setResponse(newResponse);

        // Then
        assertThat(joke.getJoke()).isEqualTo(newJoke);
        assertThat(joke.getResponse()).isEqualTo(newResponse);
    }

    @Test
    void testJokeToString() {
        // Given
        Joke joke = new Joke("C'est quoi une chauve-souris avec une perruque ?", "Une souris.");

        // When
        String jokeString = joke.toString();

        // Then
        assertThat(jokeString).isEqualTo("Joke [question=C'est quoi une chauve-souris avec une perruque ?, response=Une souris.]");
    }
}
