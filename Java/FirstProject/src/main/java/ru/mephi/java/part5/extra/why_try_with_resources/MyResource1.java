package ru.mephi.java.part5.extra.why_try_with_resources;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyResource1 implements AutoCloseable {
    public MyResource1() throws FileNotFoundException {
        System.out.println("Trying to create Resource1");
        //throw new FileNotFoundException("Resource1 wasn't found");
    }

    public void operateWithResource1() throws IOException {
        System.out.println("Trying to operate with Resource1");
        //throw new FileNotFoundException("Exception during operating with resource1");
    }
    @Override
    public void close() throws Exception {
        System.err.println("Resource1 was closed");
        throw new IOException("Exception while closing resource1");
    }
}
