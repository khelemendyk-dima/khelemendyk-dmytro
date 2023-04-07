package ua.khpi.oop.khelemendyk11;

import java.util.*;

import static ua.khpi.oop.khelemendyk11.ValidatorUtil.*;

/**
 * Menu class. Used for interacting with user in console
 *
 * @author Khelemendyk Dmytro
 * @version 1.0
 */
public class Menu {
    private final LinkedListContainer<Book> library;

    /**
     * @param library to initialize library for future work
     */
    public Menu(LinkedListContainer<Book> library) {
        this.library = Objects.requireNonNullElseGet(library, LinkedListContainer::new);
    }

    /**
     * Prints menu, gets user's command and executes it. The method works until user exit
     */
    public void startMenu() {
        boolean isOver = false;
        while (!isOver) {
            printMenu();
            int command = getCommand();
            isOver = doCommand(command);
        }
    }

    /**
     * Prints menu for user in console
     */
    private  void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Показать все книги");
        System.out.println("4. Завершить работу");
    }

    /**
     * Gets command from user to execute
     * @return command's number
     */
    private  int getCommand() {
        Scanner in = new Scanner(System.in);

        System.out.print("Выберите пункт меню: ");
        int choose = in.nextInt();
        System.out.println();

        return choose;
    }

    /**
     * Executes specified command
     * @param command command to execute
     * @return true if user chose to exit
     */
    private  boolean doCommand(int command) {
        switch (command) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> printLibrary();
            case 4 -> { return true; }
            default -> System.out.println("Выбран неверный пункт меню.");
        }

        return false;
    }

    /**
     * Asks user to input fields, validates this fields, and the adds book to the library
     */
    private  void addBook() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите ISBN: ");
        String ISBN = in.nextLine();
        while (!validateISBN(ISBN)) {
            System.out.println("Неверный ISBN. Введите ISBN в следующем формате ххх-ххх-хххххх-х\nВведите ISBN: ");
            ISBN = in.nextLine();
        }

        System.out.print("Введите название книги: ");
        String name = in.nextLine();
        while (!validateSimpleString(name)) {
            System.out.println("Неверное название книги. Назнание может содержать только буквы, цифры, точки, запятые и дефисы\nВведите название книги: ");
            name = in.nextLine();
        }

        System.out.print("Введите авторов через запятую: ");
        String[] authors = in.nextLine().split(",");
        while (!validateAuthors(authors)) {
            System.out.println("Неверное ввод авторов. Поле может содержать только буквы, точки, запятые, апострофы и дефисы\nВведите авторов через запятую: ");
            authors = in.nextLine().split(",");
        }

        System.out.print("Введите издательство: ");
        String edition = in.nextLine();
        while (!validateSimpleString(edition)) {
            System.out.println("Неверное издательство. Издательство может содержать только буквы, цифры, точки, запятые и дефисы\nВведите издательство: ");
            edition = in.nextLine();
        }

        System.out.print("Введите жанр: ");
        String genre = in.nextLine();
        while (!validateGenre(genre)) {
            System.out.println("Неверный жанр. Жанр может содержать только буквы и апостроф\nВведите жанр: ");
            genre = in.nextLine();
        }

        System.out.print("Введите дату публикации: ");
        String date = in.nextLine();
        while (!validatePublicationDate(date)) {
            System.out.println("Неверная дата публикаи. Дата может содержать только 4 цифры(от 1000 и выше)\nВведите дату публикации: ");
            date = in.nextLine();
        }

        library.add(new Book(ISBN, name, authors, edition, genre, Integer.parseInt(date)));
    }

    /**
     * If there not empty library asks user which book he wasts to remove.
     * Then removes it.
     */
    private void removeBook() {
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
     * Prints the library, listing all the books
     */
    private void printLibrary() {
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
