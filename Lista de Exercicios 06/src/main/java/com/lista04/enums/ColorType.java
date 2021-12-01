package com.lista04.enums;

public enum ColorType {
    RESET("\u001B[0m"), CYAN("\u001B[36m"), BLACK("\u001B[30m"), RED("\u001B[31m"), WHITE("\u001B[37m"),
    GREEN("\u001B[32m"), YELLOW("\u001B[33m"), BLUE("\u001B[34m"), PURPLE("\u001B[35m");

    private String value;

    private ColorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
