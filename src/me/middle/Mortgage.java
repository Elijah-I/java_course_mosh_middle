package me.middle;

public class Mortgage {
    private final double mortgage;
    private final int principal;
    private final byte years;
    private final float rate;

    public Mortgage(
            int principalMin,
            int principalMax,
            int periodMin,
            int periodMax,
            int annualMin,
            int annualMax
    ) {
        principal = DataReader.getInt("Principal (1.000 - 1.000.000): ",
                                      principalMin,
                                      principalMax);
        rate = DataReader.getFloat("Annual interest rate: ", annualMin, annualMax);
        years = DataReader.getByte("Period (Years): ", periodMin, periodMax);

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
        System.out.println("MORTGAGE\n----------\nMonthly payments: " + Formatter.number(mortgage));
    }

    public void printSchedule() {
        System.out.println("\n\nPAYMENT SCHEDULE\n----------");

        int totalPrincipal = principal;

        while (totalPrincipal > 0) {
            totalPrincipal -= (int) mortgage;
            System.out.println(Formatter.number(Math.max(totalPrincipal, 0)));
        }
    }
}
