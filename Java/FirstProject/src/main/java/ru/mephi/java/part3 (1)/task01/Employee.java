package ru.mephi.java.part3.task01;

public class Employee implements IMeasurable {
    private final static double BASE_SALARY = 1000;
    private double salary;

    public Employee() {
        this.salary = BASE_SALARY;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public double measure() {
        return this.salary;
    }

    public static double average(IMeasurable[] objects) {
        double res = 0;
        for (IMeasurable obj : objects) {
            res += obj.measure();
        }
        return res / objects.length;
    }

}


