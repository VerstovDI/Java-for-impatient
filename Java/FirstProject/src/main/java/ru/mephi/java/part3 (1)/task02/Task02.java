package ru.mephi.java.part3.task02;

import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        System.out.println("Let's create 5 employees");
        Employee[] workers = testcase();
        printTestcase(workers);
        Employee richGuy = (Employee) Employee.largest(workers);
        System.out.format("Employee with the largest salary: %s, his salary: %s", richGuy.getName(), richGuy.measure());
    }

    public static Employee[] testcase() {
        Random rnd = new Random();
        return new Employee[]{new Employee("Adam", rnd.nextInt(20000)),
                                new Employee("Victoria", rnd.nextInt(20000)),
                                new Employee("Oleg", rnd.nextInt(20000)),
                                new Employee("Sergei", rnd.nextInt(20000)),
                                new Employee("Arsen", rnd.nextInt(20000))};
    }

    public static void printTestcase(Employee[] empArr) {
        for (Employee emp : empArr) {
            System.out.format("Name: %s, Salary: %s%n", emp.getName(), emp.measure());
        }
    }
}
