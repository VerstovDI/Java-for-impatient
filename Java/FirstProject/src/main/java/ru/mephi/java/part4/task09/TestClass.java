package ru.mephi.java.part4.task09;

import ru.mephi.java.part4.task02.Point;

public class TestClass {
    //private Point p;
    int a;
    protected TestClass nextTestClass;
    protected TestClass nextTestClass2;
    /*protected AnotherTestClass eeeee;

    public void setEeeee(AnotherTestClass eeeee) {
        this.eeeee = eeeee;
    }*/

    public TestClass(int a) {
        //this.p = p;
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public TestClass getNextTestClass2() {
        return nextTestClass2;
    }

    public void setNextTestClass2(TestClass nextTestClass2) {
        this.nextTestClass2 = nextTestClass2;
    }

    public int getA() {
        return a;
    }

   /* public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }*/

    public TestClass getNextTestClass() {
        return nextTestClass;
    }

    public void setNextTestClass(TestClass nextTestClass) {
        this.nextTestClass = nextTestClass;
    }
}
