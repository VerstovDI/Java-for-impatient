package ru.mephi.java.part5.extra.TransactionFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * Класс для проведения транзакционного перемещения файла.
 * Логика работы определена функцией copyFile.
 * Класс также содержит вспомогательные private-методы для проверки и валидации
 * путей до файлов и контроля доступного дискового пространства.
 */
public class FileTransactionUtil {
    /** Размер буфера данных, копируемых при перемещении файла **/
    private static final int BUFFER_SIZE = 1024;
    
    /**
     * Функция для транзакционного перемещения файла.
     * Логика работы состоит в предварительной проверке возможности пермещения,
     * копировании файла побайтно с использованием буфера по указанному для перемещения пути,
     * удалении файла-источника. Нарушение нормальной работы программы на любом из этапов
     * приводит к откату операции - отсутствию перемещения, отсутствию файла по указанному
     * для перемещения пути, отсутствию изменений в самом файле для перемещения.
     * @param passFrom Путь к файлу, который требуется переместить.
     * @param passTo Путь, куда следует переместить файл
     * @throws FileTransactionException Исключение прерывания и отката транзакции,
     * возникшее на одном из этапов перемещения.
     */
    public static void copyFile(Path passFrom, Path passTo)
            throws FileTransactionException, InterruptedException, NotEnoughSpaceException, IOException {
        // Проверяем валидность перемещаемого файла и достаточность дискового пространства
        FileTransactionUtil.checkPath(passFrom);
        FileTransactionUtil.checkFreeSpace(passFrom, passTo);

        /* Читаем байты в буфер из перемещамого файла. Проверяем, хватает ли всё ещё места.
         * Если вдруг уже не хватает (например, кто-то уже на этот диск скачивал файл
         * какое-то время, скачал, свободного места стало меньше), откатываем операцию.
         * Иначе продолжаем.
         * Если очередная порция байтов передалась успешно, приступаем к удалению файла-источника.
         * Если удаление не удалось, откатываем операцию.
         * Если удаление удалось, значит, транзакция успешна, метод отработал.
         */
        try (InputStream inputStream = new FileInputStream(passFrom.toFile());
             OutputStream outputStream = new FileOutputStream(passTo.toFile())) {
            byte[] buf = new byte[BUFFER_SIZE]; // Буфер для порционного чтения из файла
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
                TimeUnit.SECONDS.sleep(3); // для отладки
                checkFreeSpace(passFrom, passTo);
            }
        }
    }

    /**
     * Проверяет валидность перемещаемого файла (существование файла, признак файла)
     * @param path Путь до файла
     * @throws IllegalArgumentException Выбрасывается, файл по указанному пути не существует,
     * либо объект по указанному пути не является файлом.
     */
    private static void checkPath(Path path) throws IllegalArgumentException {
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File " + path + " doesn't exist.");
        }
        if (!path.toFile().isFile()) {
            throw new IllegalArgumentException("Path " + path + " doesn't represent a file!");
        }
    }

    /**
     * Метод, проверяющий достаточность дискового пространства для совершения транзакции.
     * @param passFrom Путь до перемещаемого файла
     * @param passTo Путь до файла после перемещения
     * @throws NotEnoughSpaceException Выбрасывает исключение, когда не хватает требуемого места для
     * перемещения файла.
     */
    private static void checkFreeSpace(Path passFrom, Path passTo)
            throws NotEnoughSpaceException {
        long movingFileSize = passFrom.toFile().length();
        if (new File(passTo.toAbsolutePath().toString().substring(0,3)).getUsableSpace()
                < movingFileSize) {
            throw new NotEnoughSpaceException("Not enough space to moving file "
                    + passFrom + " to" + passTo);
        }
    }
}
