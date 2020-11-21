package ru.mephi.java.part6.Extras.GenericArraysCreation.Why_PECS_not_CEPS;

import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Employee;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

    }

    public static void printNames(ArrayList<? extends Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(e.getName());
        }
        // staff.add(new Employee("a",4,"b",1));
        //staff.add(new Manager(..)): //
    }
}
