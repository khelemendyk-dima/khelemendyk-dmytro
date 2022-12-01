package ua.khpi.oop.khelemendyk04;

import java.util.Scanner;

/**
 * Завдання: 1. використовуючи програму рішення завдання лабораторної роботи №3,
 * відповідно до прикладної задачі забезпечити обробку команд користувача у
 * вигляді текстового меню.
 * 2. Забезпечити обробку параметрів командного рядка для визначення режиму
 * роботи програми.
 *
 * @author Khelemendyk D.
 */


public class Menu {
    static final String help = "Автор: Хелемендик Д.\n1.Використовуючи програму рішення завдання лабораторної роботи №3, відповідно до прикладної задачі забезпечити обробку команд користувача у вигляді текстового меню:\n\t-введення даних(користувач вводить дані через консоль);\n\t-перегляд даних(команда друкує в консоль поточні значення данних);\n\t-виконання обчислень(замінює літери рядка на їхні номер в алфавіті);\n\t-відображення результату(друкує результат у консоль);\n\t-завершення програми.\n2.Забезпечити обробку параметрів командного рядка для визначення режиму роботи програми:\n\tпараметр \"-h\" чи \"-help\": відображається інформація про автора програми, призначення (індивідуальне завдання), детальний опис режимів роботи (пунктів меню та параметрів командного рядка);\n\tпараметр \"-d\" чи \"-debug\": в процесі роботи програми відображаються додаткові дані, що полегшують налагодження та перевірку працездатності програми: діагностичні повідомлення, проміжні значення змінних, значення тимчасових змінних та ін.\n";
    /**
     * Точка входу консольної програми.
     *
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println("Command wasn't defined");
        else {
            switch (args[0]) {
                case "-h", "-help" -> System.out.println(help);
                case "-d", "-debug" -> debug();
                default -> {}
            }
        }
    }

    /**
     * Функція виводить на екран команди, запитує команду, котру хоче виконати
     * користувач, та виконує її.
     */
    private static void debug() {
        boolean isOver = false;
        TextTranslator tt = new TextTranslator(null);

        while (!isOver) {
            // малює меню
            System.out.println("\nВиберіть команду:");
            System.out.println("0 - Завершення програми");
            System.out.println("1 - Введення даних");
            System.out.println("2 - Перегляд даних");
            System.out.println("3 - Виконання обчислень");
            System.out.println("4 - Відображення результату");
            // запитує вибір користувача
            System.out.print("Відповідь: ");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            while (answer < 0 || answer > 4) {
                System.out.println("Команда не знайдена");
                answer = scanner.nextInt();
            }
            System.out.println();
            // виконує обрану команду
            switch (answer) {
                case 0 -> isOver = true;
                case 1 -> {
                    System.out.print("Введіть текст: ");
                    scanner.nextLine();
                    String text = scanner.nextLine();
                    tt = new TextTranslator(text);
                }
                case 2 -> System.out.println("Поточні змінні:\nВведений текст: " + tt.getInputText() + "\nПереведений текст: " + tt.getTranslatedText());
                case 3 -> tt.lettersToDigits();
                case 4 -> {
                    System.out.println(tt.getTabulatedText());
                    System.out.println(tt.getTranslatedText());
                }
                default -> {
                }
            }
        }
    }
}
