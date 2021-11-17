package com.lista04.utils;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;

public class Menu implements Runnable {
    private Thread thread;
    private Map<String, Section> sections;
    private Map<String, String> options;
    private Console console;
    private Connection connection;

    public Menu(Connection connection) {
        this.connection = connection;
        this.thread = new Thread(this);
        this.sections = new HashMap<>();
        this.options = new HashMap<>();
        this.console = System.console();
    }

    public Menu addSection(String name, Section section) {
        this.sections.put(name, section);

        return this;
    }

    public Menu addOption(String sectionName, String description) {
        if (this.sections.containsKey(sectionName)) {
            this.options.put(sectionName, description);
        }

        return this;
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();

    }

    void printMenu() {
        Screen.print("\n       GERENCIAR FUNCIONÁRIOS\n", ColorType.WHITE, true);

        Screen.println("\n=====================================\n", ColorType.BLACK, true);

        for (Map.Entry<String, String> entryOptions : options.entrySet()) {
            Screen.print(String.format("(%s) ", entryOptions.getKey()), ColorType.RED, true);
            Screen.print(String.format("%s\n", entryOptions.getValue()), ColorType.WHITE);
        }

        Screen.print("\n(exit) ", ColorType.PURPLE, true);
        Screen.print("Finaliza o aplicativo", ColorType.BLACK, true);

        Screen.println("\n=====================================\n", ColorType.BLACK, true);

        Screen.print("> ", ColorType.YELLOW, true);
    }

    @Override
    public void run() {
        while (!this.thread.isInterrupted()) {
            Screen.clear();
            printMenu();

            String line = this.console.readLine();

            if (line == null)
                break;

            for (Map.Entry<String, Section> entrySection : sections.entrySet()) {
                if (line.equalsIgnoreCase("exit")) {
                    this.thread.interrupt();
                    break;
                }
                if (entrySection.getKey().equalsIgnoreCase(line)) {
                    boolean stop = false;
                    Screen.clear();
                    entrySection.getValue().print();
                    while (!stop && !this.thread.isInterrupted()) {

                        line = this.console.readLine();

                        if (line == null)
                            break;

                        Screen.clear();
                        stop = !entrySection.getValue().execute(this.console, this.connection, line);
                    }
                    break;
                }
            }
        }

        try {
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Screen.clear();
        Screen.println("Finalizado!", ColorType.GREEN);
    }

}
