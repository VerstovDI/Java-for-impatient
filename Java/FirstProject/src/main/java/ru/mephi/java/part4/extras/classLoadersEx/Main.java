package ru.mephi.java.part4.extras.classLoadersEx;

import ru.mephi.java.part3.task01.Employee;

import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> someClass2 = customClassLoader.loadClass("ru.mephi.java.part3.task01.Employee");
        Object objectOfSomeClass2 = someClass2.newInstance();
        Class<?> someClass3 = ClassLoader.getSystemClassLoader().loadClass("ru.mephi.java.part3.task01.Employee");
        Object objectOfSomeClass3 = someClass3.newInstance();
        objectOfSomeClass2 = (Employee) objectOfSomeClass3;
    }
}
