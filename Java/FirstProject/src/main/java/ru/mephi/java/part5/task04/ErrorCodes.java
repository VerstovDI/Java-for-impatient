package ru.mephi.java.part5.task04;

public enum ErrorCodes {
    OK(0, "Success"),
    FILE_NOT_FOUND(1, "File not found"),
    INCORRECT_NUMBER_FORMAT(2, "Number format is incorrect"),
    INVALID_FILE_NAME(3, "Filename is invalid"),
    NOT_OK(4, "Calculation went wrong");

    private final int code;
    private final String description;

    private ErrorCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorCodes{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
