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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                '}';
    }
}
