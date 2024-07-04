package com.openclassrooms.bobapp.model;

public class Joke {
    public String joke;
    public String response;

    public Joke() {
    }

    public Joke(String joke, String response) {
        this.joke = joke;
        this.response = response;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Joke [joke=" + joke + ", response=" + response + "]";
    }
}
