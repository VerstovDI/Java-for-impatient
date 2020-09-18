package ru.mephi.java.part5.task04;

public enum ErrorCodes {
    OK(0, "Success"),
    FILE_NOT_FOUND(1, "File not found"),
    INCORRECT_NUMBER_FORMAT(2, "Number format is incorrect"),
    INVALID_FILE_NAME(3, "Filename is invalid"),
    NOT_OK(4, "Calculation went wrong");
    // TODO: логики разделения между слоями. зачем вылетает обернутый эксепшн
    // We need to chain the exceptions to make logs readable.
    /*
    Exception chaining allows you to map one exception type to another,
    so that a method can throw exceptions defined at the same abstraction level
    as the method itself, without discarding important debugging information.
    That is, if you have a method that loads some object from a database,
    you may rather want some ResourceLoadException
    (closer related to the methods abstraction level) instead of a low-level SQLException
    even if that was the original source of the problem. However,
    if you simply catch the SQLException and throw a ResourceLoadException instead,
     you may loose important debugging information.
     Thus, chaining the exceptions is a good alternative.
     You throw a "high-level" exception, well suited for the particular method,
     but chain it with the exception that caused it.
     */

    // TODO: какое из исключений должны быть основным, какое suppressed
    /*
    В try-catch-finally - выбросится то, что в finally, а то, что в try - подавится
    Начиная с Java 7, если используем try-with-resources, наоборот, основным будет то, что
    в try, а все исключения по закрытию ресурсов будут подавлены.
     */
    // TODO: зачем нужна конструкция try-finally, если есть try-with-resourсes
    // есть ресурсы, которые определил я сам, и которые я должен закрывать вручную;
    /*
    A classic example of try…catch…finally is database resource management.
    A connection to a database needs to be established but any number of things can go wrong
    in working with it.
    A connection is a managed resource that has to be properly cleaned up regardless of what happens.
     */
    // см. инет


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
