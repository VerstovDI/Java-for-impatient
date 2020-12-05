package ru.mephi.java.part6.TheoryStaff.InvCoContrvariance;

import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Employee;
import ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance.Manager;

import java.util.ArrayList;

public class Examples {
    public static void main(String[] args) {
        /* К О В А Р И А Н Т Н О С Т Ь */
        String[] strings = new String[] {"a", "b", "c"};
        Object[] arr = strings;

        Number[] nums = new Number[5];
        nums[0] = 1;
        nums[1] = 2.3;

        /*
        Integer[] integerArray = {1, 2, 3};
        Number[] numberArray = integerArray;  // valid
        Number firstElement = numberArray[0]; // valid
        numberArray[0] = 4L;                  // throws ArrayStoreException at runtime

        Although Integer[] is a subclass of Number[],
        it can only hold Integers, and trying to assign a Long element throws a runtime exception.
         */
        /* Почему массивы сделали ковариантными и почему это хорошо?
         Чтобы сохранить некоторые полезные с точки зрения полиморфизма фичи.
         Например, методы сравнения массивов и метод перемешивания элементов массива.
        boolean equalArrays (Object[] a1, Object[] a2);
        void shuffleArray(Object[] a);
        Если бы массивы были инвариантными, не было бы возможности передавать что-то, кроме
        Object[] var; Полиморфизм пропадает.
         */
        // Т.о, ковариантность часто бывает удобна, но она ненадежна.

        /* И Н В А Р И А Н Т Н О С Т Ь */
        // Дженерики без вайлдкардов инвариантны:
        /*Тип List<A> инвариантен, так как он не является ни ковариантным, ни контравариантным .
                То есть нельзя безопасно привести ни от List<Integer> к List<Number>,
        и ни от List<Number> к List<Integer>*/
        // Ex

        ArrayList<Integer> intArrList = new ArrayList<>();
        // ArrayList<Number> numArrList = intArrList; // Not ok
        ArrayList<Integer> anotherIntArrList = intArrList; // Ok


        //А если было бы можно? Получали бы ситуации такого рода:

        // (Employee extends Manager)
        ArrayList<Manager> bosses = new ArrayList();
        // ArrayList<Employee> empls = bosses; // Нельзя, но допустим, что можно ...
        // empls.add(new Employee(...)); // Простой сотрудник среди начальства!

    }
}
