package ru.mephi.java.part3.Theory1;

public class InsertionSort implements IntSorter {

    @Override
    public int[] getSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
        return arr;
    }
}
