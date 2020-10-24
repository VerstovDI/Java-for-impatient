package ru.mephi.java.part6.task06;

import ru.mephi.java.TheoryStaff.PECS.Employee;
import ru.mephi.java.TheoryStaff.PECS.Manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayListFrom = new ArrayList<>(List.of("First", "Second", "Third"));
        ArrayList<String> arrayListTo1 = new ArrayList<>();
        appendAll1(arrayListFrom, arrayListTo1);
        System.out.println(arrayListTo1);

        ArrayList<Employee> empList = new ArrayList<>(List
                .of(new Employee("a","a"),
                new Employee("b","b")));
        ArrayList<? super Employee> destList = new ArrayList<Manager>();
        appendAll2(empList, destList);
        System.out.println(destList);

        ArrayList<? extends Manager> managerList2 = new ArrayList<>(List
                .of(new Manager("a"),
                        new Manager("b")));
        ArrayList<Manager> managerList3 = new ArrayList<>();
        appendAll3(managerList2, managerList3);
        System.out.println(managerList3);

        ArrayList<? super Manager> managerList4 = new ArrayList<>();

        appendAll4(managerList2, managerList4);
        System.out.println(managerList4);
    }

    public static <E> void appendAll1(ArrayList<E> sourceArray,
                                     ArrayList<E> destinationArray) {
        destinationArray.addAll(sourceArray);
    }

    public static <E> void appendAll2(ArrayList<E> sourceArray,
                                      ArrayList<? super E> destinationArray) {
        destinationArray.addAll(sourceArray);
    }

    public static <E> void appendAll3(ArrayList<? extends E> sourceArray,
                                      ArrayList<E> destinationArray) {
        destinationArray.addAll(sourceArray);
    }

    public static <E> void appendAll4(ArrayList<? extends E> sourceArray,
                                      ArrayList<? super E> destinationArray) {
        destinationArray.addAll(sourceArray);
    }

}
