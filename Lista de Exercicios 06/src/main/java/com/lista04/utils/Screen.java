package com.lista04.utils;

import com.lista04.enums.ColorType;

public class Screen {
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void print(String text) {
        System.out.print(ColorScreen.transform(text, null, false));
    }

    public static void print(String text, boolean bold) {
        System.out.print(ColorScreen.transform(text, null, bold));
    }

    public static void print(String text, ColorType color) {
        System.out.print(ColorScreen.transform(text, color, false));
    }

    public static void print(String text, ColorType color, boolean bold) {
        System.out.print(ColorScreen.transform(text, color, bold));
    }

    public static void println(String text) {
        System.out.println(ColorScreen.transform(text, null, false));
    }

    public static void println(String text, boolean bold) {
        System.out.println(ColorScreen.transform(text, null, bold));
    }

    public static void println(String text, ColorType color) {
        System.out.println(ColorScreen.transform(text, color, false));
    }

    public static void println(String text, ColorType color, boolean bold) {
        System.out.println(ColorScreen.transform(text, color, bold));
    }
}
