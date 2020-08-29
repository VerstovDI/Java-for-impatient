package ru.mephi.java.part4.task06;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        if (otherObject.getClass() == Item.class) {
            return super.equals(otherObject);
        }
        DiscountedItem other = (DiscountedItem) otherObject;
        return this.discount == other.discount;
    }
}
