package ru.mephi.java.part5.extra.TransactionFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    // TODO: реализовать транзакционное перемещения файла. получилось/не получилось
    //  перезаписать, удалить оттуда, если что-то не ок, то откатываем
    public static void main(String[] args) throws FileTransactionException, InterruptedException {
        MoveFile moveFileObject = new MoveFile();
        // Path passTo = Paths.get("E:\\TargetTestDir\\TransactionFile");

        /*Path passFrom = Paths.get("E:\\TestDir\\TransactionFile"); // OK-case + нет файла
        moveFileObject.moveFile(passFrom, passTo);*/

        /*Path passFrom = Paths.get("E:\\TestDir\\TransactionFile12312"); // invalid path case
        moveFileObject.moveFile(passFrom, passTo);*/

        /*Path passFrom = Paths.get("E:\\TestDir\\test10Mb"); // not enough space case 1
        Path newPassTo = Paths.get("F:\\");
        moveFileObject.moveFile(passFrom, newPassTo);*/

        // not enough space main case не забыть вкл. затуп в ф-ии
        // Сценарий:
        // 1. Просим совершить транзакцию по перемещению файла.
        // 2. Начинаем писать в файл в новом месте инфу из старого,
        // процесс перемещения выполняется...
        // 3. Внедряем искусственную задержу, чтобы успеть проимитировать,
        // что в какой-то момент места стало не хватать!
        // 4. Функция замечает факт 3, происходит откат транзакции.
        Path lastPassFrom = Paths.get("E:\\TestDir\\test10Mb");
        Path lastPassTo = Paths.get("F:\\test10Mb");
        moveFileObject.moveFile(lastPassFrom, lastPassTo);;
    }
}
