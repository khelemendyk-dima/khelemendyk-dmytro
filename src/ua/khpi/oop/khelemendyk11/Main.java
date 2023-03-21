package ua.khpi.oop.khelemendyk11;

import java.io.*;
import java.util.*;

import static ua.khpi.oop.khelemendyk11.ValidatorUtil.*;

/**
 * Завдання: Продемонструвати ефективне (оптимальне) використання регулярних виразів для перевірки коректності
 * (валідації) даних, що вводяться, перед записом в domain-об'єкти відповідно до призначення кожного поля для
 * заповнення розробленого контейнера:
 * при зчитуванні даних з текстового файла в автоматичному режимі;
 * при введенні даних користувачем в діалоговому режимі.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");
        LinkedListContainer<Book> library = getBooksFromFile(file);
        Menu dialogMenu = new Menu(library);
        dialogMenu.startMenu();
    }

    /**
     * Gets books from file, validates fields. If field is valid, then doesn't add book to the library
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

                if (validateBook(ISBN, name, authors, production, genre, publicationDate)) {
                    library.add(new Book(ISBN, name, authors, production, genre, Integer.parseInt(publicationDate)));
                } else {
                    StringJoiner book = new StringJoiner(", ");
                    book.add(ISBN)
                            .add(name)
                            .add(production)
                            .add(genre)
                            .add(Arrays.toString(authors))
                            .add(publicationDate);
                    System.out.println("Invalid data for Book: " + book);
                }

                ISBN = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Invalid .txt file.");
            return null;
        }

        return library;
    }

    /**
     * Validates Book entity
     * @param isbn book's field
     * @param name book's field
     * @param authors book's field
     * @param production book's field
     * @param genre book's field
     * @param publicationDate book's field
     * @return true, if all fields is valid
     */
    private static boolean validateBook(String isbn, String name, String[] authors, String production,
                                        String genre, String publicationDate) {
        boolean[] resultsOfValidation = new boolean[6];
        resultsOfValidation[0] = validateISBN(isbn);
        resultsOfValidation[1] = validateSimpleString(name);
        resultsOfValidation[2] = validateAuthors(authors);
        resultsOfValidation[3] = validateSimpleString(production);
        resultsOfValidation[4] = validateSimpleString(genre);
        resultsOfValidation[5] = validatePublicationDate(publicationDate);

        for (boolean result : resultsOfValidation) {
            if (!result) {
                return false;
            }
        }

        return true;
    }
}
