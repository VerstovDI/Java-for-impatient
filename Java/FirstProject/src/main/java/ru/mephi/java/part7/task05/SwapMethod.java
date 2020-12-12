package ru.mephi.java.part7.task05;

import java.util.*;

public class SwapMethod {
    public static void main(String[] args) {
        //List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(integerList);
        swap(integerList, 3, 1);
        System.out.println(integerList);
    }

    public static void swap (List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            randomAccessSwap(list, i, j);
        } else {
            sequentialAccessSwap(list, i, j);
        }
    }

    private static <T> void sequentialAccessSwap(List<T> list, int i, int j) {
        ListIterator<T> listIterator = list.listIterator(i);
        T left = listIterator.next();
        // TODO: сравнить длину от i до j и от конца до j (?)
        // TODO: по практике написать, чтобы он выслал мне + по задача ещё поспрашивает
        // посмотреть в среднем
        for (int k = i + 1; k < j; k++) {
            listIterator.next();
        }
        T right = listIterator.next();
        listIterator.set(left);
        for (int k = j + 1; k > i; k--) {
            listIterator.previous();
        }
        listIterator.set(right);
    }

    private static <T> void randomAccessSwap(List<T> lst, int i ,int j) {
        /*T el = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, el);*/
        lst.set(i, lst.set(j, lst.get(i)));
    }
}
