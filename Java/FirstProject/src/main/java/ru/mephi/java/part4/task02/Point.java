package ru.mephi.java.part4.task02;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point () {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

    @Override
    public String toString() {
        return "point" + "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;  // игнорируем
        if (otherObject == null) return false; // если это объект null ?
        if (this.getClass() != otherObject.getClass()) return false;
        Point otherObjectCasted = (Point) otherObject;
        return (Double.compare(this.x, otherObjectCasted.x) == 0)
                && (Double.compare(this.y, otherObjectCasted.y) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
