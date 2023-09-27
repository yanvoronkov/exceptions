package Lesson_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в произвольном порядке, разделенные пробелом:");
            String input = scanner.nextLine();

            // Разбиваем введенные данные на отдельные значения
            String[] values = input.split(" ");

            // Проверяем количество введенных данных
            if (values.length < 6) {
                throw new IllegalArgumentException("Количество данных меньше требуемых");
            } else if (values.length > 6) {
                throw new IllegalArgumentException("Количество данных больше требуемых");
            }

            // Извлекаем значения из массива
            String lastName = values[0];
            String firstName = values[1];
            String patronymic = values[2];
            String birthDateStr = values[3];
            String phoneNumberStr = values[4];
            String genderStr = values[5];

            // Создаем строку для записи в файл
            String dataLine = "<" + lastName + "><" + firstName + "><" + patronymic + "><" + birthDateStr + "><" + phoneNumberStr + "><" + genderStr + ">";

            // Создаем файл с названием фамилии
            File file = new File(lastName + ".txt");

            // Проверяем, существует ли файл
            boolean fileExists = file.exists();

            // Записываем данные в файл
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                if (fileExists) {
                    writer.println(); // Добавляем пустую строку перед новой записью
                }
                writer.print(dataLine);
                System.out.println("Данные успешно записаны в файл: " + file.getName());
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат введенных данных: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка чтения ввода: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

