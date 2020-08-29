package ru.mephi.java.part1.t12;

public class task12 {
    public static void main(String[] args) {
        System.out.println("Source: src.zip/java/io/BufferedReader.java; \nLines: 331-333, 341-348\n");

        // ----------LABELED BREAK EXAMPLE----------
        // Source code
        boolean eol = false;  // Source[*], str. 331-333
        char c = 0;  //
        int i;  // end of Source[*]

        int nextChar = 0;  // MY CODE
        int nChars = 5;  // MY CODE
        char[] cb = {'a', 'b', 'c', '\r', '\n'};  // MY CODE

        charLoop:
        // Source [*], str. 341-348
        for (i = nextChar; i < nChars; i++) {
            c = cb[i];
            if ((c == '\n') || (c == '\r')) {
                eol = true;
                System.out.println("\t[True] YOU ARE IN THE \"if\", BEFORE \"break charLoop\"");  // MY CODE
                break charLoop;
            }
        }  // end of Source

        // Equivalent
        boolean fl = false;
        for (i = nextChar; i < nChars; i++) {
            if (!fl) {
                c = cb[i];
                if ((c == '\n') || (c == '\r')) {
                    eol = true;
                    System.out.println("\t[Equivalent] YOU ARE IN THE \"if\", BEFORE \"break charLoop\"");  // MY CODE
                    fl = !fl;
                    break;
                }
            }
        }  // end of Source

        // ----------CONTINUE BREAK EXAMPLE----------
        // Source code
        System.out.println("\nSource: src.zip/java/lang/String.java; \nLines: 1886-1906");
        char[] source = {'h', 'e', 'l', 'p'};
        char[] target = {'c', 'i', 'l', 'b'};
        int targetCount = 2;
        int strLastIndex = 4;
        int t = 3;
        int start = t - (targetCount - 1);
        int k;
        startSearchForLastChar:
        while (true) {
            k = strLastIndex - 1;
            while (t > start) {
                if (source[t--] != target[k--]) {
                    i--;
                    System.out.println("\tI was here (before continue) [True]");
                    continue startSearchForLastChar;
                }
            }
            start--;
            t--;
            if ((t <= 0) || (start <= 0)) {
                break;
            }
        }

        // equivalent
        targetCount = 2;
        strLastIndex = 4;
        t = 3;
        start = t - (targetCount - 1);
        boolean fl1 = false;
        while (true) {
            k = strLastIndex - 1;
            while (t > start) {
                if ((source[t--] != target[k--]) && (!fl1)) {
                    i--;
                    System.out.println("\tI was here (before continue) [Equivalent]");
                    fl1 = true;
                    break;  // Become unnecessary
                }
            }
            if (fl1) {
                fl1 = false;
                continue;
            }
            start--;
            t--;
            if ((t <= 0) || (start <= 0)) {
                break;
            }
        }
    }
}
