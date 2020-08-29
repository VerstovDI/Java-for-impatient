package ru.mephi.java.part4.extras.classLoadersEx;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
    private Class<?> getClass(String name) {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b;
        try {
            b = loadClassData(file);
            Class<?> c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loading class '" + name + "'");
        if (name.startsWith("ru.mephi.java.part4.")) {
            return getClass(name);
        }
        return super.loadClass(name);
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        assert stream != null;
        int size = stream.available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] bt = new byte[0];
        try {
            bt = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bt, 0, bt.length);
    }
}
