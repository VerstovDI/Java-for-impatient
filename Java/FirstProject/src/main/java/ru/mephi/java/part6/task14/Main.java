package ru.mephi.java.part6.task14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<AutoCloseable> arrayList = new ArrayList<>();
        arrayList.add(new BadResource());
        arrayList.add(new BadResource());
        arrayList.add(new BadResource());
        arrayList.add(new BadResource());
        arrayList.add(new BadResource());
        closeAll(arrayList);
    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elements)
            throws Exception {
        Exception mainEx = null;
        for (T elem : elements) {
            try {
                elem.close();
            } catch (Exception e) {
                mainEx = new Exception(e.getMessage(), mainEx);
            }
        }
        if (mainEx != null) {
            throw mainEx;
        }
    }
}
