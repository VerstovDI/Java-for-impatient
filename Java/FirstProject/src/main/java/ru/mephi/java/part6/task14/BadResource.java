package ru.mephi.java.part6.task14;

public class BadResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Bad thing happened");
    }
}
