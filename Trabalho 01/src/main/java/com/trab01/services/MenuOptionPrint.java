package com.trab01.services;

import java.util.ArrayList;
import java.util.List;

public class MenuOptionPrint {
    private List<String> storagedPrints;

    private String error = "";

    public MenuOptionPrint() {
        this.storagedPrints = new ArrayList<>();
    }

    public void error(String errMessage) {
        this.error = "\nErro: \u001B[31m" + errMessage + "\u001B[0m";
    }

    public List<String> getStoragedPrints() {
        return storagedPrints;
    }

    public int save(String message) {
        System.out.print(message + " ");
        storagedPrints.add(message + " ");
        return storagedPrints.size() - 1;
    }

    public int saveln(String message) {
        System.out.println(message + " ");
        storagedPrints.add(message + " ");
        return storagedPrints.size() - 1;
    }

    public void updateAndPrint(int index, String value) {
        storagedPrints.set(index, storagedPrints.get(index) + value);
        println();
    }

    public void print() {
        for (int i = 0; i < storagedPrints.size(); i++) {
            String msg = storagedPrints.get(i);
            if (i == storagedPrints.size() - 1) {
                if (this.error.length() > 0)
                    System.out.println(this.error);
                this.error = "";
                System.out.print(msg);
            } else
                System.out.println(msg);
        }
    }

    public void println() {
        for (int i = 0; i < storagedPrints.size(); i++) {
            String msg = storagedPrints.get(i);
            if (i == storagedPrints.size() - 1) {
                if (this.error.length() > 0)
                    System.out.println(this.error);
                this.error = "";
                System.out.println(msg);
            } else
                System.out.println(msg);
        }
    }
}
