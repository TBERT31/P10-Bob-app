package com.openclassrooms.bobapp.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JokeService {
    
    private final JsonReader jsonReader;
    private final SecureRandom secureRandom;

    JokeService(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
        this.secureRandom = new SecureRandom();
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = this.jsonReader.getJokes();
        int randomIndex = secureRandom.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }
}
