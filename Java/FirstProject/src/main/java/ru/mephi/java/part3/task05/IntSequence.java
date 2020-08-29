package ru.mephi.java.part3.task05;

public interface IntSequence {
    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequence constant(int constInt) {
        return new IntSequence() {
            @Override
            public int next() {
                return constInt;
            }
        };
    }
}
