package ru.mephi.java.part4.task06;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        // Must return false if the parameter is null
        if (otherObject == null) return false;
        // Check that otherObject is an Item
        if (!(otherObject instanceof Item)) return false;
        // Test whether the instance variables have identical values
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && price == other.price;
    }
}
