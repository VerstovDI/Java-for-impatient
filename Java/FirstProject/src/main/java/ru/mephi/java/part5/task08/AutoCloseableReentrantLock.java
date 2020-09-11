package ru.mephi.java.part5.task08;

import java.util.concurrent.locks.ReentrantLock;

public class AutoCloseableReentrantLock extends ReentrantLock implements AutoCloseable {

    @Override
    public void close() {
        this.unlock();
    }
}
