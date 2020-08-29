package ru.mephi.java.part3.task12;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Task12 {
    public static void main(String[] args) {
        File[] files = getDirFiles("D:\\IntelliJ IDEA 2019.3.2");
        filesSort(files);
        for (File file : files) {
            System.out.println(file);
        }
    }

    public static void filesSort(File[] filesArr) {
        Comparator<File> comp = (file1, file2) -> {
            if (file1.isDirectory()) {
                if (file2.isDirectory()) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                if (file2.isDirectory()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(filesArr, comp.thenComparing(File::getName));
    }

    public static File[] getDirFiles(String dir) {
        return (new File(dir)).listFiles();
    }
}
