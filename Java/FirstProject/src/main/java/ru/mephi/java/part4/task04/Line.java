package ru.mephi.java.part4.task04;

import ru.mephi.java.part4.task02.Point;

public class Line extends Shape implements Cloneable {
    private Point secondPoint;

    public Line(Point from, Point to) {
        super(from);
        this.secondPoint = to;
    }

    @Override
    public Point getCenter() {
        return new Point((secondPoint.getX() + this.point.getX()) / 2, (secondPoint.getY() + this.point.getY()) / 2 );
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return new Line(new Point(point.getX(), point.getY()), new Point(secondPoint.getX(), secondPoint.getY()));
    }
}
