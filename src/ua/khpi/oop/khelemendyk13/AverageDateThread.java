package ua.khpi.oop.khelemendyk13;

import ua.khpi.oop.khelemendyk14.Book;
import ua.khpi.oop.khelemendyk14.LinkedListContainer;

/**
 * AverageDateThread class. Gets average date from all books in the library
 *
 * @author Khelemendyk D.
 */
public class AverageDateThread implements Runnable{
    private final LinkedListContainer<Book> library;

    public AverageDateThread(LinkedListContainer<Book> library) {
        this.library = library;
    }

    @Override
    public void run() {
        int sum = 0;

        for (Book book : library) {
            if (Thread.interrupted()) {
                System.out.println("AverageDateThread was interrupted");
                return;
            }
            sum += book.getPublicationDate();
        }

        System.out.println("getAverageDate: " + sum / library.size());
    }
}
