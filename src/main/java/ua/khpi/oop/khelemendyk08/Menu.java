package ua.khpi.oop.khelemendyk08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Book> library = new ArrayList<>();

    /**
     * Функція виконує роботу взаємодії з користувачем
     */
    public static void startMenu() {
        boolean isOver = false;
        while (!isOver){
            printMenu();
            int command = getCommand();
            isOver = doCommand(command);
        }
    }

    /**
     * Функція друкує меню взаємодії з користувачем
     */
    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Все книги");
        System.out.println("4. Сортировка");
        System.out.println("5. Сохранить");
        System.out.println("6. Загрузить");
        System.out.println("7. Завершить работу");
    }

    /**
     * Функція запитує користувача, котру команду він хоче виконати
     * @return номер команди
     */
    private static int getCommand() {
        Scanner in = new Scanner(System.in);

        System.out.print("Выберите пункт меню: ");
        int choose = in.nextInt();
        System.out.println();

        return choose;
    }

    /**
     * Функція виконує задану команду
     * @param command команда
     * @return чи вибрав користувач завершення виконання програми,
     * якщо так - повертає true, інакше - false
     */
    private static boolean doCommand(int command) {
        switch (command){
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                printLibrary();
                break;
            case 4:
                library.sort(Comparator.comparing(Book::getName));
                break;
            case 5:
                XMLCreator.encode(library);
                break;
            case 6:
                library = XMLCreator.decode();
                break;
            case 7:
                return true;
            default:
                System.out.println("Неверный пункт меню.");
        }

        return false;
    }

    /**
     * Додавання книги в бібліотеку. Функція запитує дані у
     * користувача та додає книгу у кінець списку
     */
    private static void addBook() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите ISBN: ");
        String ISBN = in.nextLine();
        System.out.print("Введите название: ");
        String name = in.nextLine();
        System.out.print("Введите авторов: ");
        String[] authors = in.nextLine().split(",");
        System.out.print("Введите издательство: ");
        String edition = in.nextLine();
        System.out.print("Введите жанр: ");
        String genre = in.nextLine();
        System.out.print("Введите дату публикации: ");
        int date = in.nextInt();
        library.add(new Book(ISBN, name, authors, edition, genre, date));
    }

    /**
     * Видалення книги. Функція запитує у користувача номер книги,
     * котру потрібно видалити.
     */
    private static void removeBook() {
        Scanner in = new Scanner(System.in);

        if (library.size() == 0) {
            System.out.println("Книг нет");
            return;
        }

        int pos;
        do {
            System.out.print("Выберите номер книги: ");
            pos = in.nextInt();
        } while (pos < 1 || pos > library.size());
        pos--;

        library.remove(pos);
    }

    /**
     * Функція друкує бібліотека, перераховуючи усі книги
     */
    private static void printLibrary() {
        if (library.size() == 0) {
            System.out.println("Книг нет");
            return;
        }

        System.out.println("-----------------------------------------");
        for (int i = 0; i < library.size(); i++) {
            System.out.println("Книга №" + (i+1) + ": ");
            System.out.println(library.get(i));
            System.out.println("-----------------------------------------");
        }
    }
}
