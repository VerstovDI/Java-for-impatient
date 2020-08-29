package ru.mephi.java.part4.task04;

import ru.mephi.java.part4.task02.Point;

public class Rectangle extends Shape implements Cloneable {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return new Point((this.point.getX() + width) / 2, (this.point.getY() + height) / 2);
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return new Rectangle(new Point(point.getX(), point.getY()), width, height);
    }
}
