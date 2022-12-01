package ua.khpi.oop.khelemendyk06;

import java.util.Scanner;

/**
 * Завдання: Реалізувати і продемонструвати тривале зберігання/відновлення
 * раніше розробленого контейнера за допомогою серіалізації/десеріалізації.
 * Реалізувати та продемонструвати порівняння, сортування та пошук елементів
 * у контейнері.
 * Розробити консольну програму та забезпечити діалоговий режим роботи з
 * користувачем для демонстрації та тестування рішення.
 *
 * @author Khelemendyk D.
 */

public class Menu {
    static SerializableContainer inputData = new SerializableContainer();
    static SerializableContainer deserializedData = new SerializableContainer();

    /**
     * Точка входу консольної програми.
     *
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        int answer = -1;
        while (answer != 0) {
            printCommands();
            answer = getAnswer();
            executeCommand(answer);
        }
    }

    /**
     * Друкує команди.
     */
    private static void printCommands() {
        System.out.println();
        System.out.println("0 - Quit");
        System.out.println("1 - Add text");
        System.out.println("2 - Current data");
        System.out.println("3 - Serialize");
        System.out.println("4 - Deserialize");
        System.out.println("5 - Compare");
        System.out.println("6 - Sort");
        System.out.println("7 - Find text");
    }

    /**
     * Отримує відповідь користувача в межах від 0 до 7 включно.
     * @return відповідь, котру вибрав користувач.
     */
    private static int getAnswer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose command: ");
        int answer = scanner.nextInt();

        while (answer < 0 || answer > 7) {
            System.out.println("Command wasn't found...Try again!");
            System.out.print("Choose command: ");
            answer = scanner.nextInt();
        }

        return answer;
    }

    /**
     * Виконує обрану користувачем команду.
     * @param answer команда користувача.
     */
    private static void executeCommand(int answer) {
        switch (answer) {
            case 1 -> addTextToContainer();
            case 2 -> printCurrentData();
            case 3 -> serializeInputData();
            case 4 -> deserializedData();
            case 5 -> printEqualityOfData();
            case 6 -> sortData();
            case 7 -> findPositionOfText();
            default -> {
            }
        }
    }

    /**
     * Додає текст до контейнера inputData.
     */
    private static void addTextToContainer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input text: ");
        String text = scanner.nextLine();
        inputData.add(text);
        System.out.println("\nText was added!");
    }

    /**
     * Друкує поточні дані введених та десериалізованних даних.
     */
    private static void printCurrentData() {
        System.out.println("\nInput data: "        + inputData.toString() +
                           "\nDeserialized data: " + deserializedData.toString());
    }

    /**
     * Запитує у користувача шлях до файлу та сериалізує дані в нього.
     */
    private static void serializeInputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input path to file: ");
        String path = scanner.nextLine();
        inputData.serialize(path);
        System.out.println("\nData was serialized");
    }

    /**
     * Запитує у користувача шлях до файлу та десериалізує дані з нього.
     */
    private static void deserializedData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input path to file: ");
        String path = scanner.nextLine();
        deserializedData = inputData.deserialize(path);
        System.out.println("\nData was deserialized");
    }

    /**
     * Порівнює вхідні та десиріалізовані дані.
     */
    private static void printEqualityOfData() {
        if (inputData.isEqual(deserializedData))
            System.out.println("\nData is equal");
        else
            System.out.println("\nData is different");
    }

    /**
     * Сортує або вхідні дані, або десериалізовані, за вибором користувача.
     */
    private static void sortData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to sort?");
        System.out.println("0 - Input data");
        System.out.println("1 - Deserialized data");
        System.out.print("Answer: ");

        int flag = scanner.nextInt();

        while (flag < 0 || flag > 1) {
            System.out.println("\nCommand wasn't found...Try again!");
            System.out.print("Answer: ");
            flag = scanner.nextInt();
        }

        if (flag == 0)
            inputData.sort();
        else
            deserializedData.sort();
    }

    /**
     * Шукає позицію текст в вхідному контейнері.
     */
    private static void findPositionOfText() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What text do you want to find?");
        System.out.print("Answer: ");
        String text = scanner.nextLine();

        int index = inputData.find(text);

        if (index == -1)
            System.out.println("Text wasn't found");
        else
            System.out.println("Text is placed on " + (index + 1) + " position");
    }
}
