package ru.mephi.java.part5.task08;

import java.util.concurrent.locks.ReentrantLock;

public class Task08 {
    public void someAnotherMethod() {
        // Вспомогательный метод нужен, т.к. ReentrantLock не AutoClosable
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        /*try(ReentrantLock reentrantLock2 = new ReentrantLock()) {
            reentrantLock2.lock();
        }*/
    }
}
