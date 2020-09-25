package ru.mephi.java.part5.extra.why_try_with_resources;


import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        //operateWithResources1();
        operateWithResources2();
    }

    public static void operateWithResources1()
            throws Exception {
        try (MyResource1 myResource1 = new MyResource1();
        MyResource2 myResource2 = new MyResource2()) {
            myResource1.operateWithResource1();
            myResource2.operateWithResource2();
        }

    }

    public static void operateWithResources2()
            throws Exception {
        Exception primaryException = null;
        MyResource1 myResource1 = null;
        MyResource2 myResource2 = null;
        try {
            myResource1 = new MyResource1();
            myResource2 = new MyResource2();
            myResource1.operateWithResource1();
            myResource2.operateWithResource2();
        } catch (Exception exception) {
            primaryException = exception;
        } finally {
            if (myResource1 != null) {
                try {
                    myResource1.close();
                } catch (Exception exception) {
                    if (primaryException == null) {
                        primaryException = exception;
                    } else {
                        primaryException.addSuppressed(exception);
                    }
                }
            }
            if (myResource2 != null) {
                try {
                    myResource2.close();
                } catch (Exception exception) {
                    if (primaryException == null) {
                        primaryException = exception;
                    } else {
                        primaryException.addSuppressed(exception);
                    }
                }
            }
            if (primaryException != null) {
                throw primaryException;
            }
        }
    }
}
