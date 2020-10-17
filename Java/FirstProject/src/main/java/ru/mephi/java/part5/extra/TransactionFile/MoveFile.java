package ru.mephi.java.part5.extra.TransactionFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFile {
    public void moveFile(Path passFrom, Path passTo) throws Exception {
        boolean isFileCopied = false;  // Флаг успешного копирования файла
        boolean isSourceFileDeleted = false;  // Флаг успешного удаления копируемого файла
        Exception mainEx = null;
        try {
            FileTransactionUtil.copyFile(passFrom, passTo);
        } catch (FileTransactionException | InterruptedException fileTransactEx) {
            mainEx = fileTransactEx;
        } finally {
            try {
                Files.delete(passTo);
            } catch (IOException ioEx) {
                System.err.println("Can't delete target file");
                if (mainEx != null) {
                    mainEx.addSuppressed(ioEx);
                } else {
                    mainEx = ioEx;
                }
            }
            System.err.println("Transaction aborted. Rollback!");
        }
        if (mainEx != null) {
            throw mainEx;
        }
    }
}
