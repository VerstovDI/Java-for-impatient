package ru.mephi.java.part6.task22;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

    }

    public static <V, T> V doWork (Callable<V> c, T ex) throws Throwable {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw new Throwable();
        }
    }
}
