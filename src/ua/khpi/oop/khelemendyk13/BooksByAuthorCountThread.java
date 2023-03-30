package ua.khpi.oop.khelemendyk13;

import ua.khpi.oop.khelemendyk14.Book;
import ua.khpi.oop.khelemendyk14.LinkedListContainer;

/**
 * BooksByAuthorCountThread class. Counts books that have concrete number of authors
 *
 * @author Khelemendyk D.
 */
public class BooksByAuthorCountThread implements Runnable {
    private final LinkedListContainer<Book> library;
    private final int numberOfAuthors;

    public BooksByAuthorCountThread(LinkedListContainer<Book> library, int numberOfAuthors) {
        this.library = library;
        this.numberOfAuthors = numberOfAuthors;
    }

    @Override
    public void run() {
        int counter = 0;

        for (Book book : library) {
            if (Thread.interrupted()) {
                System.out.println("BooksByAuthorCountThread was interrupted");
                return;
            }
            if (book.getAuthors().length == numberOfAuthors)
                counter++;
        }

        System.out.println("countBooksByAuthorCount(books that have " + numberOfAuthors +
                           " authors): " + counter + " of " + library.size() + " books");
    }
}
