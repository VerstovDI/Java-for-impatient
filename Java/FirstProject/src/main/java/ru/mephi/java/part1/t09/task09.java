package ru.mephi.java.part1.t09;

import javafx.beans.binding.StringBinding;

import java.util.Arrays;

public class task09 {
    public static void main(String[] args) {
        // My example of bad string comparison #1 (concatenation and other methods)
        System.out.println("-Example #1 (concatenation with string)-");
        String man = "a man";
        String java_guy = "I am" + " " + man;
        String java_fellow = "I am a man";
        System.out.println(" Result of BAD comparison via \"==\": " + (java_guy == java_fellow));
        System.out.println(" Result of the correct comparison: " + (java_guy.equals(java_fellow)));
        // #2
        System.out.println("-Example #2 (join arr)-");
        String[] arr = {"I", "am", "a", "man"};
        String other_guy = String.join(" ", arr);
        System.out.println(" Result of BAD comparison via \"==\": " + (other_guy == java_fellow));
        System.out.println(" Result of the correct comparison: " + (java_fellow.equals(other_guy)));
    }
}
