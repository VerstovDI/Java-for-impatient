package ru.mephi.java.part4.task08;

import ru.mephi.java.part3.MyIterators.MyIterator3;
import ru.mephi.java.part4.task02.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Arrays are classes in Java, but interfaces, primitive types, and void are not
        // Массивы
        System.out.println("----------------- Arrays (String[]) -----------------");
        System.out.println("getCanonicalName(): "  + String[].class.getCanonicalName() + "\n"
                + "getName():\t\t\t" + String[].class.getName() + "\n"
                + "getSimpleName():\t" + String[].class.getSimpleName() + "\n"
                + "getTypeName():  \t" + String[].class.getTypeName() + "\n"
                + "toString():\t\t\t" + String[].class.toString() + "\n"
                + "toGenericString():  " + String[].class.toGenericString());
        System.out.println();
        // for getName()
        //[Z = boolean
        //[B = byte
        //[S = short
        //[I = int
        //[J = long
        //[F = float
        //[D = double
        //[C = char
        //[L = any non-primitives(Object)

        // Примитивы
        int a = 1;
        Object objA = a;
        Class<?> clazz = objA.getClass();

        System.out.println("----------------- Primitives (int) -----------------");
        System.out.println("getCanonicalName(): "  + clazz.getCanonicalName() + "\n"
                + "getName():\t\t\t" + clazz.getName() + "\n"
                + "getSimpleName():\t" + clazz.getSimpleName() + "\n"
                + "getTypeName():  \t" + clazz.getTypeName() + "\n"
                + "toString():\t\t\t" + clazz.toString() + "\n"
                + "toGenericString():  " + clazz.toGenericString());
        System.out.println();

        // void
        Class<?> cl3 = void.class;
        System.out.println("----------------- void -----------------");
        System.out.println("getCanonicalName(): "  + cl3.getCanonicalName() + "\n"
                + "getName():\t\t\t" + cl3.getName() + "\n"
                + "getSimpleName():\t" + cl3.getSimpleName() + "\n"
                + "getTypeName():  \t" + cl3.getTypeName() + "\n"
                + "toString():\t\t\t" + cl3.toString() + "\n"
                + "toGenericString():  " + cl3.toGenericString());

        // Класс
        Class<?> cl4 = Point.class;
        System.out.println("----------------- Users class -----------------");
        System.out.println("getCanonicalName(): "  + cl4.getCanonicalName() + "\n"
                + "getName():\t\t\t" + cl4.getName() + "\n"
                + "getSimpleName():\t" + cl4.getSimpleName() + "\n"
                + "getTypeName():  \t" + cl4.getTypeName() + "\n"
                + "toString():\t\t\t" + cl4.toString() + "\n"
                + "toGenericString():  " + cl4.toGenericString());

        MyIterator3<String> it = MyIterator3.fromIterator(new ArrayList<String>(Arrays.asList("A","B")).iterator());
        Class<?> cl5 = it.getClass();
        System.out.println("----------------- generics -----------------");
        System.out.println("getCanonicalName(): "  + cl5.getCanonicalName() + "\n"
                + "getName():\t\t\t" + cl5.getName() + "\n"
                + "getSimpleName():\t" + cl5.getSimpleName() + "\n"
                + "getTypeName():  \t" + cl5.getTypeName() + "\n"
                + "toString():\t\t\t" + cl5.toString() + "\n"
                + "toGenericString():  " + cl5.toGenericString());
        System.out.println();

        // Вложенный класс
        Class<?> cl6 = SomeClass.SomeNestedClass.class;
        System.out.println("----------------- Nested class -----------------");
        System.out.println("getCanonicalName(): "  + cl6.getCanonicalName() + "\n"
                + "getName():\t\t\t" + cl6.getName() + "\n"
                + "getSimpleName():\t" + cl6.getSimpleName() + "\n"
                + "getTypeName():  \t" + cl6.getTypeName() + "\n"
                + "toString():\t\t\t" + cl6.toString() + "\n"
                + "toGenericString():  " + cl6.toGenericString());
        System.out.println();
    }
}
