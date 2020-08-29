package ru.mephi.java.part2.task06;


public class ModPoint {
    private double x;
    private double y;
    // Constructors
    public ModPoint() {
        this.x = 0;
        this.y = 0;
    }

    public ModPoint(double xCoordinate, double yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }
    // Getters
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    // "Point functions"
    public ModPoint translate(double xAmount, double yAmount) {
        this.x += xAmount;
        this.y += yAmount;
        return this;
    }

    public ModPoint scale(double scale) {
        this.x *= scale;
        this.y *= scale;
        return this;
    }
}
