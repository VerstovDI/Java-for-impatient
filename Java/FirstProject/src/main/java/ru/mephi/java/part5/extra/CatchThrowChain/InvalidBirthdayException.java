package ru.mephi.java.part5.extra.CatchThrowChain;

public class InvalidBirthdayException extends Exception {
    private static final long serialVersionUID = 2342686055658047285L;

    public InvalidBirthdayException() {
    }

    public InvalidBirthdayException(String message) {
        super(message);
    }

    public InvalidBirthdayException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBirthdayException(Throwable cause) {
        super(cause);
    }
}
