package Lesson_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String input = scanner.nextLine();

        try {
            if (input.isEmpty()) {
                throw new Exception("Ошибка: пустая строка!");
            }

            System.out.println("Вы ввели: " + input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
