package ua.khpi.oop.khelemendyk13;

/**
 * BooksAfterDateThread class. Counts books that bigger than concrete year
 *
 * @author Khelemendyk D.
 */
public class BooksAfterDateThread implements Runnable {
    private final LinkedListContainer<Book> library;
    private final int year;

    public BooksAfterDateThread(LinkedListContainer<Book> library, int year) {
        this.library = library;
        this.year = year;
    }

    @Override
    public void run() {
        int counter = 0;

        for (Book book : library) {
            if (Thread.interrupted()) {
                System.out.println("BooksAfterDateThread was interrupted");
                return;
            }
            if (book.getPublicationDate() > year)
                counter++;
        }

        System.out.println("countBooksAfterDate(bigger than " + year + "): " +
                            counter + " of " + library.size() + " books");
    }
}
