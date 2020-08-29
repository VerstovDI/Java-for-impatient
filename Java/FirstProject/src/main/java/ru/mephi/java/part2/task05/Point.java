package ru.mephi.java.part2.task05;

/**
 * An <code>Point</code> object represents a immutable class
 * represents a point on plane.
 * @author Verstov Danila
 * @version 1.0
 * @since 8
 */
public class Point {
    /** Field of x-coodinate */
    private final double x;
    /** Field of y-coordinate */
    private final double y;
    // Constructors
    /**
     * Constructor with no arguments,
     * creates new point with coordinates (0;0)
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    /**
     * Constructor with two arguments,
     * creates new point with coordinates (xCoordinate; yCoordinate)
     */
    public Point(double xCoordinate, double yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }
    // Getters

    /**
     * Method, which allow you to get x-coordinate of the current Point
     * @return ReturnS double x-coordinate of the current Point object
     */
    public double getX() {
        return this.x;
    }

    /**
     * Method, which allow you to get y-coordinate of the current Point
     * @return Returns double y-coordinate of the current Point object
     */
    public double getY() {
        return this.y;
    }
    // "Point functions"

    /**
     * Method, which translates x-coordinate of the current Point object
     * on double xAmount and y-coordinate on the yAmount
     * @param xAmount Amount of translation according to x-axis
     * @param yAmount Amount of translation according to y-axis
     * @return Returns this Point object with new coordinates
     */
    public Point translate(double xAmount, double yAmount) {
        return new Point(this.x + xAmount, this.y + yAmount);
    }

    /**
     * Method which scales coordinates of Point
     * @param scale The amount of changes
     * @return Returns this Point object with new coordinates
     */
    public Point scale(double scale) {
        return new Point(this.x * scale, this.y * scale);
    }
}
