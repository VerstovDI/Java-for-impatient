package ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance;

public class Manager extends Employee {
    private String[] employers;

    public Manager(String[] employers) {
        this.employers = employers;
    }

    public Manager(String name, int age, String department, double salary, String[] employers) {
        super(name, age, department, salary);
        this.employers = employers;
    }
}
