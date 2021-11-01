package com.trab01.services;

import java.util.Scanner;

import com.trab01.interfaces.VarScannerCallback;

public class VarScanner {
    private static final String NAME_REGEX = "^[a-zA-Záéíóúâêîô]+[\\-'\\s]?[a-zA-Záéíóúâêîô ]+$";
    private static final String EMAIL_REGEX = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String PASSWORD_REGEX = "^([\\w]{4,30})+$";

    public static boolean isValidName(String name) {
        return name.matches(VarScanner.NAME_REGEX);
    }

    public static boolean isValidEmail(String email) {
        return email.matches(VarScanner.EMAIL_REGEX);
    }

    public static boolean isValidAge(String age) {

        boolean regexOK = age.matches(VarScanner.NUMBER_REGEX);

        if (regexOK) {
            int ageNumber = Integer.valueOf(age);
            return ageNumber > 0 && ageNumber <= 200; // mínimo de 1 ano e máximo de 200 anos
        }

        return false;
    }

    public static boolean isValidNumber(String n, int min, int max) {
        boolean regexOK = n.matches(VarScanner.NUMBER_REGEX);

        if (regexOK) {
            int ageNumber = Integer.valueOf(n);
            return ageNumber >= min && ageNumber <= max;
        }

        return false;
    }

    public static boolean isValidPassword(String password) {
        return password.matches(VarScanner.PASSWORD_REGEX);
    }

    public static String nextName(Scanner scanner, VarScannerCallback callbackFail) {

        String name;

        while (true) {
            name = scanner.nextLine();
            if (isValidName(name))
                break;
            callbackFail.callback(name);
        }

        return name;
    }

    public static String nextEmail(Scanner scanner, VarScannerCallback callbackFail) {

        String email;

        while (true) {
            email = scanner.nextLine();
            if (isValidEmail(email))
                break;
            callbackFail.callback(email);
        }

        return email;
    }

    public static Integer nextAge(Scanner scanner, VarScannerCallback callbackFail) {
        String age;

        while (true) {
            age = scanner.nextLine();
            if (isValidAge(age))
                break;
            callbackFail.callback(age);
        }

        return Integer.valueOf(age);
    }

    public static String nextPassword(Scanner scanner, VarScannerCallback callbackFail) {
        String password;

        while (true) {
            password = scanner.nextLine();
            if (isValidPassword(password))
                break;
            callbackFail.callback(password);
        }

        return password;
    }

    public static Integer nextNumber(Scanner scanner, VarScannerCallback callbackFail, int max, int min) {
        String n;

        while (true) {
            n = scanner.nextLine();
            if (isValidNumber(n, min, max))
                break;
            callbackFail.callback(n);
        }

        return Integer.valueOf(n);
    }

}
