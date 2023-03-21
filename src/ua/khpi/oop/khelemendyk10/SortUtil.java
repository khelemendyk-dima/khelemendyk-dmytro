package ua.khpi.oop.khelemendyk10;

/**
 * SortUtil class. Allows to sort books in library by different sort fields
 *
 * @author Khelemendyk Dmytro
 */
public class SortUtil {
    /**
     * Sorts books in library by book's name in alphabetic order
     * @param library library for sorting
     */
    public static void sortBooksByName(LinkedListContainer<Book> library) {
        for (int i = 0; i < library.size(); i++) {
            for (int j = i + 1; j < library.size(); j++) {
                Book firstBook = library.get(i);
                Book secondBook = library.get(j);
                if (firstBook.getName().compareToIgnoreCase(secondBook.getName()) > 0) {
                    library.swap(firstBook, secondBook);
                }
            }
        }
    }

    /**
     * Sorts books in library by book's production in alphabetic order
     * @param library library for sorting
     */
    public static void sortBooksByProduction(LinkedListContainer<Book> library) {
        for (int i = 0; i < library.size(); i++) {
            for (int j = i + 1; j < library.size(); j++) {
                Book firstBook = library.get(i);
                Book secondBook = library.get(j);
                if (firstBook.getProduction().compareToIgnoreCase(secondBook.getProduction()) > 0) {
                    library.swap(firstBook, secondBook);
                }
            }
        }
    }

    /**
     * Sorts books in library by book's genre in alphabetic order
     * @param library library for sorting
     */
    public static void sortBooksByGenre(LinkedListContainer<Book> library) {
        for (int i = 0; i < library.size(); i++) {
            for (int j = i + 1; j < library.size(); j++) {
                Book firstBook = library.get(i);
                Book secondBook = library.get(j);
                if (firstBook.getGenre().compareToIgnoreCase(secondBook.getGenre()) > 0) {
                    library.swap(firstBook, secondBook);
                }
            }
        }
    }

    /**
     * Sorts books in library by book's publication date in ascending order
     * @param library library for sorting
     */
    public static void sortBooksByPublicationDate(LinkedListContainer<Book> library) {
        for (int i = 0; i < library.size(); i++) {
            for (int j = i + 1; j < library.size(); j++) {
                Book firstBook = library.get(i);
                Book secondBook = library.get(j);
                if (firstBook.getPublicationDate() > secondBook.getPublicationDate()) {
                    library.swap(firstBook, secondBook);
                }
            }
        }
    }
}
