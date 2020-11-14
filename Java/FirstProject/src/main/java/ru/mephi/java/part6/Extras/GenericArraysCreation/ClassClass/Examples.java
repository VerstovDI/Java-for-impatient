package ru.mephi.java.part6.Extras.GenericArraysCreation.ClassClass;

import java.util.List;

public class Examples {
    public static void main(String[] args) {
        // #1 см. ранее
        // #2
        Something smth = new Something();
        smth.put(Integer.class, 5);
        smth.put(String.class, "Buy");
        Integer someInteger = smth.get(Integer.class);
        String someString = smth.get(String.class);
        System.out.println(someInteger);
        System.out.println(someString);


    }
}
