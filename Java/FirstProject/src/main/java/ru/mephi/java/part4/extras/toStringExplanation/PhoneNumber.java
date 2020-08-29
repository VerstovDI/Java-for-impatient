package ru.mephi.java.part4.extras.toStringExplanation;

public class PhoneNumber {
    int countryCode;
    int operator;
    int main_number;

    public PhoneNumber(int countryCode, int operator, int main_number) {
        this.countryCode = countryCode;
        this.operator = operator;
        this.main_number = main_number;
    }

    @Override
    public String toString() {
        return "+" + countryCode
                + "-"
                + operator
                + "-"
                + main_number;
    }
}
