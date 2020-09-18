package ru.mephi.java.part5.extra.TransactionFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    // TODO: реализовать транзакционное перемещения файла. получилось/не получилось
    //  перезаписать, удалить оттуда, если что-то не ок, то откатываем
    public static void main(String[] args) {

    }

    public static boolean transactionFilePerforming(File baseFile, File targetDirectory, File logFile)
            throws FileTransactionException, IOException {
        if (!baseFile.isFile()) {
            throw new FileTransactionException(baseFile + "isn't a file!");
        }
        if (!targetDirectory.isDirectory()) {
            throw new FileTransactionException(targetDirectory + "isn't a directory!");
        }
        if (!logFile.isFile()) {
            throw new FileTransactionException(logFile + "isn't a file!");
        }
        File tmpFile = File.createTempFile(baseFile.toString(), targetDirectory.toString());
        Files.move(baseFile.toPath(), targetDirectory.toPath()); // Invalid path exception
        return false;
    }

    public static boolean transactionInfoFromFile(File sourceFile, File targetDir) {
        return false;
    }
}
