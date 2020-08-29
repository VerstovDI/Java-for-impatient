package ru.mephi.java.part3.task04;


public class Task04 {
    public static void main(String[] args) {
        int[] intArr = { 5, 6, 7, 8, 9, 10};
        IntSequenceExtra ise = IntSequenceExtra.of(intArr);
        while (ise.hasNext()) {
            System.out.format("%s ", ise.next());
        }
        System.out.println("\n");
        IntSequence ise2 = IntSequence.of(intArr);
        while (ise2.hasNext()) {
            System.out.format("%s ", ise2.next());
        }
    }
}
