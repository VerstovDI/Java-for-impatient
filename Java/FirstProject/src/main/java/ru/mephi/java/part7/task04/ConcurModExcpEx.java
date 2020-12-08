package ru.mephi.java.part7.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConcurModExcpEx {
    public static void main(String[] args) {
        List<String> stringList
                = new ArrayList<>(){{ add("abc"); add("hello"); add("avorad"); add("amid");}};
        //doDuplicatesWrong(stringList);

        doDuplicatesOk(stringList);
        System.out.println(stringList);
    }

    public static void doDuplicatesWrong(List<String> stringList) {
        for (String s : stringList) {
            s.toUpperCase();
            stringList.add(s.toLowerCase());
        }
    }

    public static void doDuplicatesOk(List<String> stringList) {
        ListIterator<String> it = stringList.listIterator();
        while(it.hasNext()) {
            String s = it.next();
            it.set(s.toUpperCase());
        }
        it = stringList.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            it.add(s.toLowerCase());
        }
    }
}
