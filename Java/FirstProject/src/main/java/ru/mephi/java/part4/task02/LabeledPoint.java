package ru.mephi.java.part4.task02;


import java.util.Objects;

public class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public LabeledPoint(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "labeled " + super.toString() + " , name = \"" + this.label + "\"";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        LabeledPoint otherObjectCasted = (LabeledPoint) otherObject;
        return Objects.equals(this.label, otherObjectCasted.label);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(this.label);
    }
}
