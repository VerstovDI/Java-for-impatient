package ru.mephi.java.part5.extra.TransactionFile;

public class FileTransactionException extends Exception {
    private static final long serialUID = 1231231231444L;

    public FileTransactionException() {
    }

    public FileTransactionException(String message) {
        super(message);
    }

    public FileTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTransactionException(Throwable cause) {
        super(cause);
    }
}
