package me.middle;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public Employee(int baseSalary, int hourlyRate) {
        this.setBaseSalary(baseSalary);
        this.setHourlyRate(hourlyRate);
    }

    public int getWage(int extraHours) {
        validateNumber(extraHours, "extraHours");
        return this.baseSalary + (this.hourlyRate * extraHours);
    }

    private void validateNumber(int Number, String name) {
        if (Number <= 0)
            throw new IllegalArgumentException(name + " should be more than 0.");
    }

    private void setBaseSalary(int baseSalary) {
        validateNumber(baseSalary, "baseSalary");
        this.baseSalary = baseSalary;
    }

    private void setHourlyRate(int hourlyRate) {
        validateNumber(hourlyRate, "hourlyRate");
        this.hourlyRate = hourlyRate;
    }
}
