package ru.mephi.java.part4.task03.anotherPackage;

import ru.mephi.java.part4.task03.LabeledPoint;
import ru.mephi.java.part4.task03.Point;

public class exampleClass {
    public String label;
    int k;
    double x;

    public exampleClass(String label, int k) {
        LabeledPoint p = new LabeledPoint("T", 2, 3);
        this.k = k;
        this.label = p.getLabel();
        //this.x = p.x;  // но this.x = p.getX() корректно
    }
}
