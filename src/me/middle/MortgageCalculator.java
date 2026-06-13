package me.middle;

public class MortgageCalculator {
    private final double mortgage;
    private final int principal;
    private final byte years;
    private final float rate;

    public MortgageCalculator(int[] principalLimits, int[] periodLimits, int[] annualLimits) {
        principal = Console.getInt("Principal: ", principalLimits[0], principalLimits[1]);
        years = Console.getByte("Period (Years): ", periodLimits[0], periodLimits[1]);
        rate = Console.getFloat("Annual interest rate: ", annualLimits[0], annualLimits[1]);

        mortgage = this.calculateMortgage();
    }

    private double calculateMortgage() {
        byte PERCENT = 100;
        byte MONTH_IN_YEAR = 12;

        int period = years * MONTH_IN_YEAR;
        float monthRate = rate / MONTH_IN_YEAR / PERCENT;
        double ratedPeriod = Math.pow(1 + monthRate, period);

        return (principal * (monthRate * ratedPeriod) / (ratedPeriod - 1));
    }

    public void printMortgage() {
        Console.log("MORTGAGE\n----------\nMonthly payments: " + Formatter.number(mortgage));
    }

    public void printSchedule() {
        Console.log("\n\nPAYMENT SCHEDULE\n----------");

        int totalPrincipal = principal;

        while (totalPrincipal > 0) {
            totalPrincipal -= (int) mortgage;
            Console.log(Formatter.number(Math.max(totalPrincipal, 0)));
        }
    }
}
