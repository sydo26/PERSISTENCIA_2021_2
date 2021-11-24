package com.lista04.utils;

import com.lista04.enums.ColorType;

public class ColorScreen {
    public static String transform(String text, ColorType color, boolean isBold) {
        if (color == null)
            return ColorType.RESET.getValue() + (isBold ? "\033[0;1m" : "") + text + ColorType.RESET.getValue();
        return ColorType.RESET.getValue() + (isBold ? "\033[0;1m" : "") + color.getValue() + text
                + ColorType.RESET.getValue();
    }
}
