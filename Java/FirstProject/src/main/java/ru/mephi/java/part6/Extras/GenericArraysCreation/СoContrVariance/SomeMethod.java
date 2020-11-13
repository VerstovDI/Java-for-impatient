package ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance;

import java.util.ArrayList;
import java.util.List;

public class SomeMethod {
    public static void main(String[] args) {
        // Covariance
        Manager manager1 = new Manager(
                "Oleg",
                10,
                "IT",
                5000,
                new String[]{"Petrov", "Sidorov"});
        Employee employee1 = new Employee("Aidar", 20, "IT", 3500);
        Employee employee2 =  new Employee("Kopenko", 22, "SALES", 3300);
        ArrayList<Employee> allStaff = new ArrayList<>();

        System.out.println(salaryExpenditure(allStaff));

        System.out.println(salaryExpenditure2(allStaff));
        Manager manager2 = new Manager("Orton",
                25,
                "SALES",
                6000,
                new String[]{"Conan", "Igor"});

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(manager1);
        managers.add(manager2);
        System.out.println(salaryExpenditure(managers));
        // System.out.println(salaryExpenditure2(managers)); а вот тут так нельзя уже!

        // Contravariance

    }

    public static double salaryExpenditure(List<? extends Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public static double salaryExpenditure2(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }
}
