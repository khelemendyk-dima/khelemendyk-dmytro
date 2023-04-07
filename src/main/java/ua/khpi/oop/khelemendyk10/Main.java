package ua.khpi.oop.khelemendyk10;

import java.io.*;

/**
 * Завдання: 1. Розробити параметризовані методи (Generic Methods) для обробки колекцій об'єктів згідно прикладної задачі.
 * 2. Продемонструвати розроблену функціональність (створення, управління та обробку власних контейнерів) в діалоговому
 * та автоматичному режимах.
 * - Автоматичний режим виконання програми задається параметром командного рядка -auto. Наприклад, java ClassName -auto.
 * - В автоматичному режимі діалог з користувачем відсутній, необхідні данні генеруються, або зчитуються з файлу.
 * Бібліотека. Сортування за назвою, за видавництвом, за жанром, за датою видання.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListContainer<Book> library = new LinkedListContainer<>();

        if (args.length != 0 && args[0].equals("-auto")) {
            File file = new File("file.txt");
            library = getBooksFromFile(file);
        }

        Menu dialogMenu = new Menu(library);
        dialogMenu.startMenu();
    }

    /**
     * Gets books from file. If file is wrong, then books won't be added to the container
     * @param file file from what need to read books
     * @return list of books
     */
    private static LinkedListContainer<Book> getBooksFromFile(File file) {
        LinkedListContainer<Book> library = new LinkedListContainer<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String ISBN = reader.readLine();
            while (ISBN != null) {
                String name = reader.readLine();
                String[] authors = reader.readLine().split(",");
                String production = reader.readLine();
                String genre = reader.readLine();
                String publicationDate = reader.readLine();

                library.add(new Book(ISBN, name, authors, production, genre, Integer.parseInt(publicationDate)));

                ISBN = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Invalid .txt file.");
            return null;
        }

        return library;
    }

}
