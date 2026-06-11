package me.middle;

public class Main {
    static void main() {
        var mortgage = new Mortgage(
                1_000,
                1_000_000,
                1,
                30,
                1,
                30);

        mortgage.printMortgage();
        mortgage.printSchedule();
    }
}