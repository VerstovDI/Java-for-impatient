package ru.mephi.java.part5.task08;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // Вариант 1
        try (AutoCloseable autoCloseable = helperToReentrantLock(new ReentrantLock())) {
            // some code
        } catch (Exception ex) {
            System.err.println("Thrown exception" + ex.getMessage());
        }

        // Вариант 2
        try (AutoCloseable locker = lock()) {
            // ...
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }

    public static AutoCloseable helperToReentrantLock(ReentrantLock reentrantLock) {
        reentrantLock.lock();
        return reentrantLock::unlock;
    }

    public static AutoCloseable lock() {
        AutoCloseableReentrantLock locker = new AutoCloseableReentrantLock();
        locker.lock();
        return locker;
    }
}
