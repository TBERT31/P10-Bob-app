package com.openclassrooms.bobapp.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.bobapp.model.Joke;

@Repository
public class JsonReader {
    private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode jsonFile;

    public JsonReader() {
        try {
            this.getJsonFile();
        } catch (IOException e) {
            logger.error("Erreur lors du chargement du fichier JSON", e);
        }
    }

    private static class SingletonHolder {
        private static final JsonReader instance = new JsonReader();
    }

    public static JsonReader getInstance() {
        return SingletonHolder.instance;
    }

    public List<Joke> getJokes() {
        JsonNode jokeNode = this.jsonFile.get("jokes");
        Joke[] persons = mapper.convertValue(jokeNode, Joke[].class);
        return Arrays.asList(persons);
    }

    protected void getJsonFile() throws IOException {
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