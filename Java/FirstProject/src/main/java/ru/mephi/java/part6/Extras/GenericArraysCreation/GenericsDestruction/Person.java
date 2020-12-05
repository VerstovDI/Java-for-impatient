package ru.mephi.java.part6.Extras.GenericArraysCreation.GenericsDestruction;

public class Person {
    private String name;
    private int age;
    private boolean male;

    public Person() {
        this.name = "unknown";
        this.age = 0;
        this.male = true;
    }

    public Person(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }
}

