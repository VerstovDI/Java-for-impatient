package ru.mephi.java.part3.task16Extra;

import java.util.Collections;

class MyStringComparators {
    final static class MyNullComparator implements MyStringComparator {
        private final boolean nullFirst;
        private final MyStringComparator real;

        public MyNullComparator (boolean nullFirst, MyStringComparator real) {
            this.nullFirst = nullFirst;
            this.real = (MyStringComparator) real;
        }

        public int compare(String a, String b) {
            if (a == null) {
                return (b == null) ? 0 : (nullFirst ? -1 : 1);
            } else if (b == null) {
                return nullFirst ? 1 : -1;
            } else {
                return (real == null) ? 0 : real.compare(a, b);
            }
        }
    }
}
