package ru.mephi.java.part6.Extras.GenericArraysCreation.GenericsDestruction;

import ru.mephi.java.part3.Theory3.Animal;
import ru.mephi.java.part6.task07.Pair;

public class DestroyGenerics {
    public static void main(String[] args) {
        SomethingHolder<Integer> integerHolder;

        SomethingHolder<Person> personHolder;
        personHolder = new SomethingHolder(new Person("Da.", 20, true));

        integerHolder = (SomethingHolder) personHolder;
        System.out.println(integerHolder.getSomething());
        int x = integerHolder.getSomething() + 6;
    }
}
