package com.openclassrooms.bobapp.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.bobapp.model.Joke;

@Repository
public class JsonReader {
    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode jsonFile;

    private JsonReader() {
        try {
            this.getJsonFile();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static class SingletonHolder {
        private final static JsonReader instance = new JsonReader();
    }

    public static JsonReader getInstance() {
        return SingletonHolder.instance;
    }

    public List<Joke> getJokes() {
        JsonNode jokeNode = this.jsonFile.get("jokes");
        Joke[] persons = mapper.convertValue(jokeNode, Joke[].class);
        return Arrays.asList(persons);
    }

    private void getJsonFile() throws IOException, URISyntaxException {
        if (this.jsonFile == null) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("json/jokes.json");
            if (is == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                this.jsonFile = mapper.readTree(is);
            }
        }
    }
}
