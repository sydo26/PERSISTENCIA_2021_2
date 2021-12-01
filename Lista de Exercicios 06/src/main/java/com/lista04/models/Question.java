package com.lista04.models;

public class Question {
    private String question;
    private String response;

    public Question(String question, String response) {
        this.question = question;
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }
}
