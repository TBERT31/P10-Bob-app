package com.openclassrooms.bobapp.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;

@Service
public class JokeService {
    
    private final JsonReader jsonReader;
    private final Random generator;

    JokeService(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
        this.generator = new Random();
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = this.jsonReader.getJokes();
        int randomIndex = generator.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }
}
