package com.openclassrooms.bobapp.data;

import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonReaderTest {

    private static JsonReader jsonReader;

    @BeforeAll
    public static void setup() {
        jsonReader = JsonReader.getInstance();
    }

    @Test
    public void testGetJokes() throws IOException, URISyntaxException {
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
    public void testGetInstance() {
        // Arrange & Act
        JsonReader instance1 = JsonReader.getInstance();
        JsonReader instance2 = JsonReader.getInstance();

        // Assert
        assertThat(instance1).isSameAs(instance2); // Should be the same instance (singleton)
    }


}
