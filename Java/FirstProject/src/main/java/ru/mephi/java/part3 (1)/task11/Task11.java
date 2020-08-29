package ru.mephi.java.part3.task11;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Task11 {
    public static void main(String[] args) {
        System.out.println(getFilesWithExtentionLambda("D:\\", "fb2"));
    }

    public static ArrayList<File> getFilesWithExtentionLambda(String dir, String ext) {
        File f = new File(dir);
        ArrayList<File> requiredFiles = new ArrayList<>();
        for (File item : Objects
                .requireNonNull(f
                        .listFiles(pathname -> { return (pathname.getName()).endsWith(ext);}))) {
            requiredFiles.add(item);
        }
        return requiredFiles;
    }
}
