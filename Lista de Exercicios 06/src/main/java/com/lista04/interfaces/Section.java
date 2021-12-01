package com.lista04.interfaces;

import java.io.Console;

public interface Section<R> {
    public void print();

    public boolean execute(Console console, String response, R repository);
}
