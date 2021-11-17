package com.lista04.interfaces;

import java.io.Console;
import java.sql.Connection;

public interface Section {
    public void print();

    public boolean execute(Console console, Connection con, String response);
}
