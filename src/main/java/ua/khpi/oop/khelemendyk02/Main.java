package ua.khpi.oop.khelemendyk02;

import java.util.Random;

/**
 * Завдання: 10. Знайти кількість комбінацій 01 та 10 в двійковому
 * запису цілого числа.
 *
 * @author Khelemendyk D.
 */

public class Main {
    /**
     * Точка входу консольної програми.
     *
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        printTable();
    }

    /**
     * Виведення до консолі відповідних значень вхідних
     * даних та результатів обчислень у вигляді таблиці.
     */
    private static void printTable() {
        Random random = new Random();

        System.out.println("Number\t\t| Pattern: 01 | Pattern: 10 |");
        System.out.println("----------------------------------------|");

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt();
            int pattern01 = countBinaryCombination(number, 0, 1);
            int pattern10 = countBinaryCombination(number, 1, 0);
            System.out.printf("%s\t|%12s |%12s |\n", number, pattern01, pattern10);
        }

        System.out.println("________________________________________|");
    }

    /**
     * Функція рахує кількість співпадань заданної комбінації в двійковому
     * запису цілого числа.
     *
     * @param number ціле число
     * @param firstDigit перше число двійкової комбінації
     * @param secondDigit друге число комбінації
     * @return кількість співпадань заданної комбінації.
     */
    static int countBinaryCombination(int number, int firstDigit, int secondDigit) {
        if (number < 0) {
            number = -number;
        }

        int counter = 0;
        int prevDigit = number % 2;
        int currDigit;

        while (number > 0) {
            currDigit = number % 2;

            if (currDigit == firstDigit && prevDigit == secondDigit)
                counter++;

            prevDigit = currDigit;
            number /= 2;
        }
        return counter;
    }
}
