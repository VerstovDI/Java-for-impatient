package ru.mephi.java.part5.extra.why_try_with_resources;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyResource2 implements AutoCloseable {

    public MyResource2() throws FileNotFoundException {
        System.out.println("Trying to create Resource2");
         throw new FileNotFoundException("Resource2 wasn't found");
    }

    public void operateWithResource2() throws IOException {
        System.out.println("Trying to operate with Resource2");
        //throw new FileNotFoundException("Exception during operating with resource2");
    }
    @Override
    public void close() throws Exception {
        System.err.println("Resource2 was closed");
        throw new IOException("Exception while closing resource #2");
    }
}
