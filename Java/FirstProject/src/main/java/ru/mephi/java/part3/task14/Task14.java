package ru.mephi.java.part3.task14;

import ru.mephi.java.part3.task02.Employee;

import java.util.Arrays;
import java.util.Comparator;


public class Task14 {
    public static void main(String[] args) {
        Employee[] empArr = new Employee[] { new Employee("Misha", 1500),
                                        new Employee("Kirill", 12300),
                                        new Employee("Dima", 6700),
                                        new Employee("Nazar", 22500),
                                        new Employee("Aidar", 22500)};
        printEmployees(empArr);
        //cleverEmployeeSort(empArr);
        cleverEmployeeSortReversed(empArr);
        printEmployees(empArr);
    }

    public static void cleverEmployeeSort(Employee[] empArr) {
        Arrays.sort(empArr, Comparator.comparing(Employee::measure).thenComparing(Employee::getName));
    }

    public static void cleverEmployeeSortReversed(Employee[] empArr) {
        Arrays.sort(empArr, Comparator.comparing(Employee::measure).thenComparing(Employee::getName).reversed());
    }

    public static void printEmployees(Employee[] empArr) {
        for (Employee emp : empArr) {
            System.out.format("Name: %s, salary: %s%n", emp.getName(), emp.measure());
        }
        System.out.println();
    }
}
