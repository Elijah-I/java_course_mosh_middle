package me.middle;

public class ErrorHandler {
    public static <T extends Number & Comparable<T>> void validateMinMax(T number, T min, T max) {
        if (number.compareTo(min) <= 0 || number.compareTo(max) >= 0)
            System.out.println("Error: enter value between " + min + " and " + max);
    }
}
