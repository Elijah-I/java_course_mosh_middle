package me.middle;

public class Main {
    static void main() {
        var employee = new Employee(50_000, 20);
        int wage = employee.getWage(10);
        System.out.println(wage);
    }
}
