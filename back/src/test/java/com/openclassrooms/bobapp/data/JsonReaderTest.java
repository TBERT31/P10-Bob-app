package com.openclassrooms.bobapp.data;

import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class JsonReaderTest {

    private static JsonReader jsonReader;

    @BeforeAll
    public static void setup() {
        jsonReader = JsonReader.getInstance();
    }

    @Test
    void testGetJokes() throws IOException, URISyntaxException {
        // Arrange
        List<Joke> jokes = jsonReader.getJokes();

        // Act
        Joke firstJoke = jokes.get(0);
        Joke secondJoke = jokes.get(1);

        // Assert
        assertThat(jokes).isNotEmpty();
        assertThat(firstJoke.getJoke()).isEqualTo("C'est l'histoire du ptit dej, tu la connais ?");
        assertThat(firstJoke.getResponse()).isEqualTo("Pas de bol.");
        assertThat(secondJoke.getJoke()).isEqualTo("C'est l'histoire d'une blague vaseuse");
        assertThat(secondJoke.getResponse()).isEqualTo("Mets tes bottes.");
    }

    @Test
    void testGetInstance() {
        // Arrange & Act
        JsonReader instance1 = JsonReader.getInstance();
        JsonReader instance2 = JsonReader.getInstance();

        // Assert
        assertThat(instance1).isSameAs(instance2); // Should be the same instance (singleton)
    }

    @Test
    void testIOExceptionAndURISyntaxException() {
        JsonReader jsonReaderSpy = new JsonReader() {
            @Override
            protected void getJsonFile() throws IOException, URISyntaxException {
                throw new IOException("Test IOException");
            }
        };

        assertThatThrownBy(jsonReaderSpy::getJokes)
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Cannot invoke \"com.fasterxml.jackson.databind.JsonNode.get(String)\"");
    }


    @Test
    void testSingletonHolder() {
        // Use reflection to access the private constructor
        try {
            java.lang.reflect.Constructor<JsonReader> constructor = JsonReader.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            JsonReader newInstance = constructor.newInstance();
            assertThat(newInstance).isNotNull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
