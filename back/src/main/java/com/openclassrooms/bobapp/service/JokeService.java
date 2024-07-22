package com.openclassrooms.bobapp.service;

import java.util.List;
//import java.util.Random;

import org.springframework.stereotype.Service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JokeService {
    
    private final JsonReader jsonReader;

    JokeService(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = this.jsonReader.getJokes();
        // Utilisation de ThreadLocalRandom pour une génération sûre de nombres aléatoires dans un environnement multithreadé
        int randomIndex = ThreadLocalRandom.current().nextInt(jokes.size());
        return jokes.get(randomIndex);
    }
}
