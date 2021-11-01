package com.trab01.services;

import java.util.HashMap;
import java.util.Map;

import com.trab01.interfaces.MenuCallback;
import com.trab01.model.MenuOption;
import com.trab01.threads.MenuThread;

public class Menu {

    private Map<String, MenuOption> options;
    private Thread menuThread;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Menu() {
        this.options = new HashMap<>();
        this.menuThread = new MenuThread(this.options);
    }

    public void addOption(String key, Integer code, MenuCallback callback) {
        this.options.putIfAbsent(key, new MenuOption(code, callback));
    }

    public void start() {
        this.menuThread.start();
    }

    public void stop() {
        this.menuThread.interrupt();
    }

}
