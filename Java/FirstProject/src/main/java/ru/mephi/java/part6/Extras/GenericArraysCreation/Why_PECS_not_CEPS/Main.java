package ru.mephi.java.part6.Extras.GenericArraysCreation.Why_PECS_not_CEPS;

import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Employee;
import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Manager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Alexey", 22, "IT", 4000);
        Manager manager = new Manager("Boris", 36, "IT", 40000, new String[]{});
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(manager);
        arrayList.add(employee);
        ArrayList<Object> newLst = new ArrayList<>();

        doSomethingAndAdd1(newLst, employee);
    }

    public static void doSomethingAndAdd1(ArrayList<? super Employee> emps, Employee emp) {
        // ...
        emps.add(emp);
        Employee e = (Employee) emps.get(0); // вот тут просто будет вылетать ClassCastException всегда
        // Если бы Consumer мог produce,
        // то тогда бы от этого нельзя было бы извлечь пользу, всегда бы вылетал exception
    }

    public static void doSomethingAndAdd2(ArrayList<? extends Employee> emps, Employee emp) {
        // ...
        //emps.add(emp);
    }

}
