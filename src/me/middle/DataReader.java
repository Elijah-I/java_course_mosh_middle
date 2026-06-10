package me.middle;

import java.util.Scanner;
import java.util.function.Supplier;

public class DataReader {
    static Scanner scanner = new Scanner(System.in);

    private static <T extends Number & Comparable<T>> T getNumber(
            String message,
            T min,
            T max,
            Supplier<T> getter
    ) {
        T number;

        while (true) {
            System.out.print(message);
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
}
