package ru.mephi.java.part3.task16Extra;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToIntFunction;

@FunctionalInterface
public interface MyStringComparator  {
    int compare(String s1, String s2);

    boolean equals(Object obj);

    default MyStringComparator reversed() {
        return (s1, s2) -> s2.compareTo(s1);
    }

    default int compareString(String s1, String s2) {
        return s1.compareTo(s2);
    }

    static MyStringComparator comparing(Function<String, String> func) {
        Objects.requireNonNull(func);
        return (s1, s2) -> func.apply(s1).compareTo(func.apply(s2));
    }

    static MyStringComparator comparing(Function<String, String> func, MyStringComparator myComp) {
        Objects.requireNonNull(func);
        Objects.requireNonNull(myComp);
        return (s1, s2) -> myComp.compare(func.apply(s1), func.apply(s2));
    }

    default MyStringComparator thenComparing(MyStringComparator other) {
        Objects.requireNonNull(other);
        return (s1, s2) -> {
            int res = compare(s1, s2);
            return (res != 0) ? res : other.compare(s1, s2);
        };
    }

    default MyStringComparator nullsFirst() {
        return new MyStringComparators.MyNullComparator(true, this);
    }

    default Comparator<String> toComparator() {
        return this::compare;
    }
}
