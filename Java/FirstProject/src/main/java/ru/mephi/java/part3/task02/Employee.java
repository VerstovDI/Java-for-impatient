package ru.mephi.java.part3.task02;


public class Employee implements IMeasurable {
    private double salary = 1000;
    private String name;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
        this.name = "";
    }

    @Override
    public double measure() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    public static IMeasurable largest(IMeasurable[] objects) {
        IMeasurable maxSalaryEmployee = new Employee();
        double maxSalary = 0;
        for (IMeasurable obj : objects) {
            if (maxSalary < obj.measure()) {
                maxSalary = obj.measure();
                maxSalaryEmployee = obj;
            }
        }
        return maxSalaryEmployee;
    }

    public static double average(IMeasurable[] objects) {
        double res = 0;
        for (IMeasurable obj : objects) {
            res += obj.measure();
        }
        return res / objects.length;
    }
}
