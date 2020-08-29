package ru.mephi.java.part3.task05;

@FunctionalInterface
public interface IntSequenceExtra {
    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequenceExtra constant(int constInt) {
        return () -> constInt;
    }
}
