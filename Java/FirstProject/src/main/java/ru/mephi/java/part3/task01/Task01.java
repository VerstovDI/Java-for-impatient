package ru.mephi.java.part3.task01;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int countOfWorkers = 1 + rand.nextInt(10);
        System.out.format("Created %s of worker(-s) with different salary(-ies):%n", countOfWorkers);
        Employee[] employees = testCreateEmployees(countOfWorkers);
        printEmployees(employees);
        System.out.format("Average salary: %s RUB%n", Math.round(Employee.average(employees)));
    }

    public static Employee[] testCreateEmployees(int cnt) {
        Random rnd = new Random();
        Employee[] workers = new Employee[cnt];
        for (int i = 0; i < cnt; i++) {
            workers[i] = new Employee(500 + rnd.nextInt(20000));
        }
        return workers;
    }

    public static void printEmployees(Employee[] empArr) {
        System.out.println("   -Salaries of employees-:");
        int j = 0;
        for (Employee emp: empArr) {
            System.out.format("    Empl. #%s: %7s RUB%n", j, emp.measure());
            j++;
        }
        System.out.format("%n");
    }

}
