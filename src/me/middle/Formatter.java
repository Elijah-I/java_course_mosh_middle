package me.middle;

import java.text.NumberFormat;

public class Formatter {
    private static final NumberFormat number = NumberFormat.getCurrencyInstance();

    public static <T extends Number> String number(T numberToFormat) {
        return number.format(numberToFormat);
    }
}
