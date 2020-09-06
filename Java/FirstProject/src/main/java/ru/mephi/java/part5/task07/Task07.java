package ru.mephi.java.part5.task07;

import java.util.Scanner;

public class Task07 {
    public static void someMethod() {
        /*
        Если исключение будет выброшено в основном коде и в методе close(),
        то приоритетнее будет первое исключение,
        а второе исключение будет подавлено,
        но информация о нем сохранится
        (с помощью метода Throwable.addSuppressed(Throwable exception),
        который вызывается неявно Java компилятором (и соотв. getSuppressed))
        Если просто try-catch-finally и закрываем ресурс в finally,
        то изначальное исключение пропадет (будет только, например, NullPointerEx,
        а его причину, например, FileNotFoundEx, программист не узнает)
         */
    }
}
