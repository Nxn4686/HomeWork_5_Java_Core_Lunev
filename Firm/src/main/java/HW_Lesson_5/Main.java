package HW_Lesson_5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
 * во вновь созданную папку ./backup
 */

public class Main {

    public static void main(String[] args) {
        String sourceDir = "src/main/java/testFolder";
        String backupDir = "src/main/java/testFolder/backup";

        createBackup(sourceDir, backupDir);

    }

    public static void createBackup(String sourceDir, String backupDir) {
        File sourceFolder = new File(sourceDir);
        File backupFolder = new File(backupDir);

        if(!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        if (sourceFolder.exists() && sourceFolder.isDirectory()) {
            File[] files = sourceFolder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                Path sourcePath = file.toPath();
                                Path backupPath = Paths.get(backupFolder.getAbsolutePath(), file.getName());

                                Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);

                                System.out.println("Файл " + file.getName() + " скопирован в " + backupPath);
                            } catch (IOException e) {
                                System.err.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                            }
                        }
                    }
                }
        } else {
            System.err.println("Исходная директория не существует или не является директорией.");
        }
    }
}

/**
 * 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой, например,
 * состояния ячеек поля для игры в крестикинолики,
 * где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
 * Такое предположение позволит хранить в одном числе типа int всё поле 3х3. Записать в файл 9 значений так,
 * чтобы они заняли три байта. Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет".
 */

