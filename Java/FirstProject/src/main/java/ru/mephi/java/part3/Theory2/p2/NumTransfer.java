package ru.mephi.java.part3.Theory2.p2;

import java.util.Arrays;

public class NumTransfer {
    public int transfer(int val, INumericSeparator sepNums) {
        if (val == 0) {
            return 0;
        }
        int[] arr = sepNums.separateNums(val);
        int[] oddArr = new int[Math.round((float) arr.length/2)];
        int[] evenArr = new int[arr.length/2];
        int oddTmp = 0;
        int evenTmp = 0;
        int i = 1;
        while (i <= arr.length) {
            if (i % 2 != 0) {
                oddArr[oddTmp] = arr[i-1];
                oddTmp++;
            } else {
                evenArr[evenTmp] = arr[i-1];
                evenTmp++;
            }
            i++;
        }
        Arrays.sort(evenArr);
        i = 1;
        evenTmp = 0;
        oddTmp = 0;
        while (i <= arr.length) {
            if (i % 2 != 0) {
                arr[i-1] = oddArr[oddTmp];
                oddTmp++;
            } else {
                arr[i-1] = evenArr[evenTmp];
                evenTmp++;
            }
            i++;
        }
        return Integer.parseInt(intArrToStr(arr));
    }

    private String intArrToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value);
        }
        return sb.toString();
    }
}
