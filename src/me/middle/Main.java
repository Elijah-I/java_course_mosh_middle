package me.middle;

public class Main {
    static void main() {
        var employee = new Employee();
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);

        int wage = employee.getWage(10);

        System.out.println(wage);
    }
}
