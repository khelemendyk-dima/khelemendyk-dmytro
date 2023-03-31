package ua.khpi.oop.khelemendyk15;


import java.util.*;


/**
 * Menu class. Used for interacting with user in console
 *
 * @author Khelemendyk Dmytro
 * @version 1.0
 */
public class Menu {
    private final List<Book> library;

    /**
     * @param library to initialize library for future work
     */
    public Menu(List<Book> library) {
        this.library = library != null ? library : new ArrayList<>();
    }

    /**
     * Prints menu, gets user's command and executes it. The method works until user exit
     */
    public void startMenu() {
        boolean isOver = false;
        while (!isOver){
            printMenu();
            int command = getCommand();
            isOver = doCommand(command);
        }
    }

    /**
     * Prints menu for user in console
     */
    private void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Показать все книги");
        System.out.println("4. Сортировать по имени");
        System.out.println("5. Сортировать по издательству");
        System.out.println("6. Сортировать по жанру");
        System.out.println("7. Сортировать по дате выпуска");
        System.out.println("8. Завершить работу");
    }

    /**
     * Gets command from user to execute
     * @return command's number
     */
    private int getCommand() {
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
    private boolean doCommand(int command) {
        switch (command) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> printLibrary();
            case 4 -> library.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            case 5 -> library.sort(((o1, o2) -> o1.getProduction().compareToIgnoreCase(o2.getProduction())));
            case 6 -> library.sort(((o1, o2) -> o1.getGenre().compareToIgnoreCase(o2.getGenre())));

            case 7 -> library.sort((o1, o2) -> {
                if (o1.getPublicationDate() > o2.getPublicationDate())
                    return 1;
                else if (o1.getPublicationDate() == o2.getPublicationDate())
                    return 0;
                return -1;
            });

            case 8 -> {
                return true;
            }
            default -> System.out.println("Неверный пункт меню.");
        }

        return false;
    }

    /**
     * Asks user to input fields, and the adds book to the library
     */
    private void addBook() {
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
