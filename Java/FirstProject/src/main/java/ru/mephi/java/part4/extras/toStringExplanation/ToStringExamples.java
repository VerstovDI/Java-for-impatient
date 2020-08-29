package ru.mephi.java.part4.extras.toStringExplanation;

import ru.mephi.java.part4.extras.toStringExplanation.PhoneNumber;
import ru.mephi.java.part4.task02.Point;

public class ToStringExamples {
    public static void main(String[] args) {
        System.out.println("The point of the center is " + new Point(3,2));
        /*The toString method is automatically invoked when an object is passed to
        println, printf, the string concatenation operator, or assert, or is printed by a
        debugger. Even if you never call toString on an object, others may. For example,
        a component that has a reference to your object may include the string representation
        of the object in a logged error message. If you fail to override toString, the
        message may be all but useless.
        If you’ve provided a good toString method for PhoneNumber, generating a
        useful diagnostic message is as easy as this:
        {Jenny=PhoneNumber@163b91} or {Jenny=707-867-5309}?
        Assertion failure: expected {abc, 123}, but was {abc, 123}.
        */
        PhoneNumber phoneNumber = new PhoneNumber(7,977,5543133);
        // ... основной код
        // -- блок кода, отвечающий за соединения
        // ... if (...) {
        System.out.println("Failed to connect to " + phoneNumber);
        // }
    }
}
