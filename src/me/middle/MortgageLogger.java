package me.middle;

public class MortgageLogger {
    private final MortgageCalculator calculator;

    public MortgageLogger(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        Console.log("MORTGAGE\n----------\nMonthly payments: ", true);
        Console.log(Formatter.number(calculator.getMortgage()));
    }

    public void printSchedule() {
        Console.log("\n\nPAYMENT SCHEDULE\n----------");

        var totalPrincipals = calculator.getTotalPrincipals();

        for (double totalPrincipal : totalPrincipals) {
            Console.log(Formatter.number(totalPrincipal));
        }
    }
}
