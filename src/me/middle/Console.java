package me.middle;

import java.util.Scanner;
import java.util.function.Supplier;

public class Console {
    static Scanner scanner = new Scanner(System.in);

    private static <T extends Number & Comparable<T>> T getNumber(
            String message,
            T min,
            T max,
            Supplier<T> getter
    ) {
        T number;

        while (true) {
            log(message, true);
            number = getter.get();

            if (number.compareTo(min) >= 0 && number.compareTo(max) <= 0) {
                break;
            }

            ErrorHandler.validateMinMax(number, min, max);
        }

        return number;
    }

    public static int getInt(String message, int min, int max) {
        return getNumber(message, min, max, scanner::nextInt);
    }

    public static byte getByte(String message, int min, int max) {
        return getNumber(message, (byte) min, (byte) max, scanner::nextByte);
    }

    public static float getFloat(String message, int min, int max) {
        return getNumber(message, (float) min, (float) max, scanner::nextFloat);
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void log(String message, boolean inline) {
        if (inline) {
            System.out.print(message);
            return;
        }

        log(message);
    }
}
