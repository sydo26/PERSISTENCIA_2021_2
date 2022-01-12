package com.trab02.shared.ui;

public class Screen {
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
