package ru.mephi.java.part3.task05;

public class Task05 {
    public static void main(String[] args) {
        IntSequence const1 = IntSequence.constant(1);
        IntSequenceExtra const2 = IntSequenceExtra.constant(9);
        tester1(const1);
        System.out.println();
        tester2(const2);
    }

    public static void tester1(IntSequence constInterface) {
        int j = 0;
        while (constInterface.hasNext() && j++ < 10) {
            System.out.format("%s ", constInterface.next());
        }
    }

    public static void tester2(IntSequenceExtra constInterfaceExtra) {
        int j = 0;
        while (constInterfaceExtra.hasNext() && j++ < 10) {
            System.out.format("%s ", constInterfaceExtra.next());
        }
    }
}
