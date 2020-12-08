package ru.mephi.java.part7.task03;

import java.util.HashSet;
import java.util.Set;

public class SetStaff {
    public static void main(String[] args) {
        Set<Integer> setOfIntsA = new HashSet<>() {{add(3); add(4); add(5); add(6);}};
        Set<Integer> setOfIntsB = new HashSet<>() {{add(5); add(6); add(7); add(8);}};
        Set<Integer> resultSetOfInts = new HashSet<>();

        doSetOperation(OperationType.UNION, setOfIntsA,setOfIntsB, resultSetOfInts);
        System.out.println(resultSetOfInts);

        resultSetOfInts = new HashSet<>();
        doSetOperation(OperationType.DIFFERENCE, setOfIntsA,setOfIntsB, resultSetOfInts);
        System.out.println(resultSetOfInts);

        resultSetOfInts = new HashSet<>();
        doSetOperation(OperationType.INTERSECTION, setOfIntsA,setOfIntsB, resultSetOfInts);
        System.out.println(resultSetOfInts);
    }

    public static <T> Set<T> doSetOperation(OperationType opType,
                                            Set<T> setA, Set<T> setB, Set<T> resultSet) {
        resultSet.addAll(setA);
        if (opType.equals(OperationType.UNION)) {
            resultSet.addAll(setB);
        } else if (opType.equals(OperationType.DIFFERENCE)) {
            resultSet.removeAll(setB);
        } else {
            resultSet.retainAll(setB);
        }
        return resultSet;
    }
}
