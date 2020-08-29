package ru.mephi.java.part4.task01;

public class Point2 {
    private double x;
    private double y;

    public Point2 () {
           this.x = 0.0;
           this.y = 0.0;
    }

    public Point2(double x, double y) {
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

    public String info() {
        return "Point";
    }
}
