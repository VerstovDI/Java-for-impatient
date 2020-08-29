package ru.mephi.java.part3.task10;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Objects;


public class Task10 {
    public static void main(String[] args) {
        System.out.println(allSubcatalogs("C:\\"));
        System.out.println(allSubcatalogsLambda("C:\\"));
        System.out.println(allSubcatalogsAnon("C:\\"));
    }

    public static ArrayList<File> allSubcatalogs(String catalog) {
        File currCatalog = new File(catalog);
        ArrayList<File> subCatalogs = new ArrayList<>();
        if (currCatalog.isDirectory()) {
            for (File item : Objects.requireNonNull(currCatalog.listFiles())) {
                if (item.isDirectory()) {
                    subCatalogs.add(item);
                }
            }
        } else {
            throw new IllegalArgumentException("The input parameter is not a catalog!");
        }
        return subCatalogs;
    }

    public static ArrayList<File> allSubcatalogsLambda(String catalog) {
        File currCatalog = new File(catalog);
        ArrayList<File> subCatalogs = new ArrayList<>();
        for (File item : Objects.requireNonNull(currCatalog.listFiles(pathname -> pathname.isDirectory()))) {             //File::isDirectory()
            subCatalogs.add(item);
        }
        return subCatalogs;
    }

    public static ArrayList<File> allSubcatalogsAnon(String catalog) {
        File currCatalog = new File(catalog);
        ArrayList<File> subCatalogs = new ArrayList<>();
        for (File item : Objects
                .requireNonNull(currCatalog.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            };}))
        ) {
            subCatalogs.add(item);
        }
        return subCatalogs;
    }
}
