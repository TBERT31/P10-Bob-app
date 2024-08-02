package com.openclassrooms.bobapp.model;

public class Joke {
    private String question;
    private String response;

    public Joke() {
    }

    public Joke(String question, String response) {
        this.question = question;
        this.response = response;
    }

    public String getJoke() {
        return question;
    }

    public void setJoke(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Joke [question=" + question + ", response=" + response + "]";
    }
}
