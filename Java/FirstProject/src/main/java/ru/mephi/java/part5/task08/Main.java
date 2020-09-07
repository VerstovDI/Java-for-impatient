package ru.mephi.java.part5.task08;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        try (AutoCloseable autoCloseable = helperToReentrantLock(new ReentrantLock())) {
            // some code
        } catch (Exception ex) {
            System.err.println("Thrown exception" + ex.getMessage());
        }
    }

    public static AutoCloseable helperToReentrantLock(ReentrantLock reentrantLock) {
        reentrantLock.lock();
        return reentrantLock::unlock;
    }
}
