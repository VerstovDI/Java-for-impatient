package ru.mephi.java.part3.Theory1;

public class ShellSort implements IntSorter {
    @Override
    public int[] getSorted(int[] arr) {
        int gap = arr.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < arr.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (arr[c] > arr[c + gap]) {
                        //IntSorter.swap(arr, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
        return arr;
    }
}
