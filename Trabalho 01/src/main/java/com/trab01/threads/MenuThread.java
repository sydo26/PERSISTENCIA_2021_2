package com.trab01.threads;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.trab01.model.MenuOption;
import com.trab01.services.Menu;

public class MenuThread extends Thread {

    protected Map<String, MenuOption> options;
    protected Scanner scanner;

    public MenuThread(Map<String, MenuOption> options) {
        this.options = options;
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    @Override
    public void interrupt() {
        super.interrupt();
        this.scanner.close();
    }

    protected Map<String, MenuOption> useOrderedOptions() {
        List<Entry<String, MenuOption>> list = new LinkedList<Entry<String, MenuOption>>(this.options.entrySet());

        Collections.sort(list, new Comparator<Entry<String, MenuOption>>() {
            public int compare(Entry<String, MenuOption> o1, Entry<String, MenuOption> o2) {
                return o1.getValue().getCode().compareTo(o2.getValue().getCode());
            }
        });

        Map<String, MenuOption> sortedMap = new LinkedHashMap<String, MenuOption>();
        for (Entry<String, MenuOption> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Menu.clearScreen();
            System.out.println("\n================== [MENU] ==================\n");
            for (Map.Entry<String, MenuOption> optionEntry : this.useOrderedOptions().entrySet()) {
                System.out.println(optionEntry.getValue().getCode() + " - " + optionEntry.getKey());
            }
            System.out.println("\n============================================\n");

            System.out.print("> ");

            String codeStr = this.scanner.nextLine();

            int code;

            try {
                code = Integer.valueOf(codeStr);
                for (Map.Entry<String, MenuOption> optionEntry : this.options.entrySet()) {
                    if (optionEntry.getValue().isCode(code)) {
                        Menu.clearScreen();
                        optionEntry.getValue().getCallback().callback(optionEntry.getKey(), this.scanner);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }
}
