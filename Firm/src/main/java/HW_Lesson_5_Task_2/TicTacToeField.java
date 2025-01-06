package HW_Lesson_5_Task_2;
import java.io.*;
import java.util.Random;

public class TicTacToeField {

    public static void main(String[] args) {
        int[] field = new int[9];
        Random rand = new Random();

        for (int i = 0; i < 9; i++) {
            field[i] = rand.nextInt(4);
        }

        byte[] bytes = new byte[3];
        int bitIndex = 0;

        for (int i = 0; i < 9; i++) {
            int value = field[i];
            int byteIndex = bitIndex / 8;
            int bitPosition = bitIndex % 8;

            bytes[byteIndex] |= (value << (6 - bitPosition));

            bitIndex += 2;
        }

        try (FileOutputStream fos = new FileOutputStream("ticTacToeField.dat")) {
            fos.write(bytes);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        System.out.println("Массив значений:");
        for (int i = 0; i < 9; i++) {
            System.out.print(field[i] + " ");
        }
        System.out.println();
    }
}

