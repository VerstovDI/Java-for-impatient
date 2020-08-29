package ru.mephi.java.part4.task09;

import ru.mephi.java.part4.task02.Point;

public class Main {
    public static void main(String[] args) {
        UniversalToString toStringTransformer = new UniversalToString();
        TestClass testClass1 = new TestClass(1);
        TestClass testClass2 = new TestClass(2); // new Point(2,2),
        TestClass testClass3 = new TestClass(3);
        TestClass testClass4 = new TestClass(4);
        // --- 1
       /* testClass1.setNextTestClass(testClass2);
        testClass1.setNextTestClass2(testClass3);
        testClass2.setNextTestClass(testClass4);
        testClass2.setNextTestClass2(testClass1);
        testClass3.setNextTestClass2(testClass1);
        AnotherTestClass anotherTestClass = new AnotherTestClass();
        anotherTestClass.setTestClassReference(testClass1);
        testClass4.setEeeee(anotherTestClass);
        testClass3.setNextTestClass(testClass4);
        testClass4.setNextTestClass(testClass1);
        System.out.println(toStringTransformer.universalToString(testClass1));*/
        // --- 2

        /*testClass1.setNextTestClass(testClass2);
        testClass2.setNextTestClass(testClass3);
        testClass3.setNextTestClass(testClass4);
        testClass4.setNextTestClass(testClass1);*/

        testClass1.setNextTestClass(testClass2);
        testClass1.setNextTestClass2(testClass3);
        testClass2.setNextTestClass(testClass4);
        testClass3.setNextTestClass(testClass4);
        testClass4.setNextTestClass(testClass1);
        UniversalToString2 toStringTransformer2 = new UniversalToString2();
        System.out.println(toStringTransformer2.universalToString(testClass1));

    }

}
