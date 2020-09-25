package ru.mephi.java.part5.extra.TransactionFile;

public class NotEnoughSpaceException extends Exception {
    private static final long serialUID = 123134514L;

    public NotEnoughSpaceException() {
    }

    public NotEnoughSpaceException(String message) {
        super(message);
    }

    public NotEnoughSpaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughSpaceException(Throwable cause) {
        super(cause);
    }
}
