package ru.mephi.java.part6.TheoryStaff.Other;

public class A<T extends Number> {
    T valueA;

    void setValue(T value) {
        this.valueA = value;  // В runtime стирается до void setValue(Number value)
    }
}
