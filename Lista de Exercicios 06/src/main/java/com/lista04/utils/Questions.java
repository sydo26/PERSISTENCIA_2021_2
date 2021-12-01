package com.lista04.utils;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.lista04.enums.ColorType;
import com.lista04.enums.ValidatorType;
import com.lista04.models.Question;

public class Questions {
    private List<Question> questions;
    private Console console;
    private String title;

    public Questions(String title, Console console) {
        this.questions = new ArrayList<>();
        this.console = console;
        this.title = title;
    }

    public void printQuestions() {
        Screen.clear();
        Screen.println(this.title, ColorType.WHITE, true);

        for (Question q : questions) {
            Screen.print(String.format("%s ", q.getQuestion()), ColorType.WHITE, false);
            Screen.println(String.format("%s\n", q.getResponse()), ColorType.GREEN);
        }
    }

    private String getResponse(String question) {
        Screen.print(String.format("%s ", question), ColorType.YELLOW, true);
        String response = "";

        while ((response = this.console.readLine()) != null) {
            if (!(response.isBlank() || response.isEmpty()))
                break;
            Screen.clear();
            Screen.print(String.format("%s ", question), ColorType.YELLOW, true);
        }

        return response;
    }

    public String ask(String question) {

        this.printQuestions();

        String response = this.getResponse(question);

        this.questions.add(new Question(question, response));

        this.printQuestions();

        return response;
    }

    public String ask(String question, ValidatorType validator) {

        this.printQuestions();

        String response;

        while (!(response = this.getResponse(question)).matches(validator.getValue())) {
            this.printQuestions();
            Screen.println(String.format("[FORMATO INVÁLIDO]: %s", validator.getMessage()), ColorType.RED);
        }

        this.questions.add(new Question(question, response));

        this.printQuestions();

        return response;
    }
}
