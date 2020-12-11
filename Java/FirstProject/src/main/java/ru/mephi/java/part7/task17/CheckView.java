package ru.mephi.java.part7.task17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckView {
    public static void main(String[] args) {
        List<Integer> checkInts = Collections.checkedList(new ArrayList<>(), Integer.class);
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("hello");
        checkInts.addAll(arrayList);
    }
}
