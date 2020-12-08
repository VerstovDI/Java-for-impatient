package ru.mephi.java.part7.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task2UppercaseStrings {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList1
                = new ArrayList<>() {{ add("Hello"); add("ABC"); add("bye-bye"); }};
        makeAllUppercaseIterator(stringArrayList1);
        System.out.println(stringArrayList1);

        ArrayList<String> stringArrayList2
                = new ArrayList<>() {{ add("Hello"); add("ABC"); add("bye-bye"); }};
        makeAllUppercaseLoop(stringArrayList2);
        System.out.println(stringArrayList2);

        ArrayList<String> stringArrayList3
                = new ArrayList<>() {{ add("Hello"); add("ABC"); add("bye-bye"); }};
        makeAllUppercaseReplaceAll(stringArrayList3);
        System.out.println(stringArrayList3);
    }

    public static void makeAllUppercaseIterator(List<String> strings) {
        ListIterator<String> stringIterator = strings.listIterator();
        while (stringIterator.hasNext()) {
            stringIterator.set(stringIterator.next().toUpperCase());
        }
    }

    public static void makeAllUppercaseLoop(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, strings.get(i).toUpperCase());
        }
    }

    public static void makeAllUppercaseReplaceAll(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
    }
}
