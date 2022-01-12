package com.trab02.shared.ui;

import java.util.Scanner;

public abstract class IUI {

    protected Scanner scanner;

    public IUI() {
        this.scanner = new Scanner(System.in);
    }

    public abstract void run(String... args);

}
