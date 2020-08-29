package ru.mephi.java.part4.task04;

import ru.mephi.java.part4.task02.Point;

public class Circle extends Shape implements Cloneable {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return this.point;
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return new Circle(new Point(point.getX(), point.getY()), radius);
    }
}
