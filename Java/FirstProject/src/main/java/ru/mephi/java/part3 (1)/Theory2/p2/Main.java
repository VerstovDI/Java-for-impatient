package ru.mephi.java.part3.Theory2.p2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*Поставим следующую алгоритмическую задачу.
         Пусть дано натуральное число. Необходимо сформировать такое новое число, которое будет в точности
         равно данному, но будет записано наоборот, с конца, приём на чётных позициях цифры будут отсортированы
         по возрастанию (нумерация с 1).
         Пример: 145682 -> 216548 ( -> 286541 (8,5,1->1,5,8) -> 216548
         Если после данной процедуры новое число начинается с нуля (например, 210), то лидирующие нули опускаются (12)
         */
         INumericSeparator sepNums = (int val) -> {
             ArrayList<Integer> arr = new ArrayList<>();
             String s = Integer.toString(val);
             while (val > 0) {
                 arr.add(val % 10);
                 val = val / 10;
             }
             return arr.stream().mapToInt(i -> i).toArray();
         };

         NumTransfer nt = new NumTransfer();
         System.out.println(nt.transfer(145682, sepNums));
         System.out.println(nt.transfer(2930184, sepNums));
         System.out.println(nt.transfer(0, sepNums));
         System.out.println(nt.transfer(23, sepNums));
         System.out.println(nt.transfer(756, sepNums));
         int res = nt.transfer(1430, sepNums);
         System.out.println(nt.transfer(1430, sepNums));
    }
}
