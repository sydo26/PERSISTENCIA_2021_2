package com.lista04.utils;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;

public class Menu<R> {
    private Map<String, Section<R>> sections;
    private Map<String, String> options;
    private Console console;
    private R repository;

    public Menu(R repository) {
        this.sections = new HashMap<>();
        this.options = new HashMap<>();
        this.console = System.console();
        this.repository = repository;
    }

    public Menu<R> addSection(String name, Section<R> section) {
        this.sections.put(name, section);

        return this;
    }

    public Menu<R> addOption(String sectionName, String description) {
        if (this.sections.containsKey(sectionName)) {
            this.options.put(sectionName, description);
        }

        return this;
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

    public void init() {
        boolean running = true;
        while (running) {
            Screen.clear();
            printMenu();

            String line = this.console.readLine();

            if (line == null)
                break;

            for (Map.Entry<String, Section<R>> entrySection : sections.entrySet()) {
                if (line.equalsIgnoreCase("exit")) {
                    running = false;
                    break;
                }
                if (entrySection.getKey().equalsIgnoreCase(line)) {
                    boolean stop = false;
                    Screen.clear();
                    entrySection.getValue().print();
                    while (!stop && running) {

                        line = this.console.readLine();

                        if (line == null)
                            break;

                        Screen.clear();
                        stop = !entrySection.getValue().execute(this.console, line, this.repository);
                    }
                    break;
                }
            }
        }

        Screen.clear();
        Screen.println("Finalizado!", ColorType.GREEN);
    }

}
