package ru.mephi.java.part5.extra.TransactionFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFile {
    public void moveFile(Path passFrom, Path passTo) {
        boolean result = false;
        try {
            result = FileTransactionUtil.transactCopyFile2(passFrom, passTo);
        } catch (FileTransactionException | InterruptedException fileTransactEx) {
            try {
                Files.delete(passTo);
            } catch (IOException ioEx) {
                System.err.println("Can't delete target file");
                fileTransactEx.addSuppressed(ioEx);
                System.err.println(fileTransactEx.getMessage());
            }
        } finally {
            if (result) {
                System.err.println("Transaction successfully completed!");
            } else {
                System.err.println("Transaction aborted. Rollback!");
            }
        }
    }
}
