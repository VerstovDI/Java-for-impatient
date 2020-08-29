package ru.mephi.java.part4.extras.classLoadersEx;

import ru.mephi.java.part3.task01.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*CustomClassLoader myClassLoader = new CustomClassLoader();
        Class<?> someClass = loadClass("SomeClass", true);*/
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> someClass2 = customClassLoader.loadClass("ru.mephi.java.part3.task01.Employee");
        Class<?> someClass3 = ClassLoader.getSystemClassLoader().loadClass("ru.mephi.java.part3.task01.Employee");
        Object objectOfSomeClass2 = someClass2.newInstance();
        Object objectOfSomeClass3 = someClass3.newInstance();
        objectOfSomeClass3 = (Employee) objectOfSomeClass2;
        /*try {
            someClass3.getMethod("printSomething").invoke(objectOfSomeClass3);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }*/
    }
}
