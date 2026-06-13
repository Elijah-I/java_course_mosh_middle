package me.middle;

public class Main {
    static void main() {
        var mortgage = new MortgageCalculator(
                new int[]{1_000, 1_000_000},
                new int[]{1, 30},
                new int[]{1, 30});

        mortgage.printMortgage();
        mortgage.printSchedule();
    }
}