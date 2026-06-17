package me.middle;

public class MortgageCalculator implements IMortgageCalculator {
    private final double mortgage;
    private final int principal;
    private final byte years;
    private final float rate;

    public MortgageCalculator(int[] principalLimits, int[] periodLimits, int[] annualLimits) {
        principal = Console.getInt("Principal: ", principalLimits[0], principalLimits[1]);
        years = Console.getByte("Period (Years): ", periodLimits[0], periodLimits[1]);
        rate = Console.getFloat("Annual interest rate: ", annualLimits[0], annualLimits[1]);

        mortgage = calculateMortgage();
    }

    @Override
    public double calculateMortgage() {
        byte PERCENT = 100;
        byte MONTH_IN_YEAR = 12;

        int period = years * MONTH_IN_YEAR;
        float monthRate = rate / MONTH_IN_YEAR / PERCENT;
        double ratedPeriod = Math.pow(1 + monthRate, period);

        return (principal * (monthRate * ratedPeriod) / (ratedPeriod - 1));
    }

    @Override
    public double[] getTotalPrincipals() {
        int steps = (int) Math.ceil(principal / mortgage);
        var totalPrincipals = new double[steps];
        int totalPrincipal = principal;

        for (int step = 0; step < steps; step++) {
            totalPrincipal -= (int) mortgage;
            totalPrincipals[step] = Math.max(totalPrincipal, 0);
        }

        return totalPrincipals;
    }

    @Override
    public double getMortgage() {
        return mortgage;
    }
}
