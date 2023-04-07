package ua.khpi.oop.khelemendyk03;

import java.util.Scanner;

/**
 * Завдання: 5. Ввести текст. У тексті кожну літеру замінити її номером в алфавіті.
 * Вивести результат наступним чином: в одному рядку друкувати текст з двома
 * пропусками між буквами, в наступному рядку під кожною буквою друкувати
 * її номер.
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
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(addTabulationBetweenLetters(text));
        System.out.println(lettersToDigits(text));
    }

    /**
     * Функція додає табуляцію між буквами.
     * @param text - текст, котрий потрібно обробити.
     * @return обробленний текст.
     */
    public static String addTabulationBetweenLetters(String text) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int temp = text.charAt(i) - 64;
            if (temp > 0)
                res.append(text.charAt(i)).append("\t");
        }
        return res.toString();
    }

    /**
     * Функція заміняє літери їхні номера в алфавіті.
     * @param text текст, котрий потрібно обробити.
     * @return рядок з числами, розділені табуляцією.
     */
    public static String lettersToDigits(String text) {
        StringBuilder res = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            int temp = text.charAt(i) - 64;
            if (temp > 0)
                res.append(temp).append("\t");
        }
        return res.toString();
    }
}
