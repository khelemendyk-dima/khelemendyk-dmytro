package ua.khpi.oop.khelemendyk14;

import static ua.khpi.oop.khelemendyk14.GeneratorUtil.generateLibrary;

/**
 * Завдання:
 * 1. Забезпечити вимірювання часу паралельної обробки елементів контейнера за допомогою розроблених раніше методів.
 * 2. Реалізувати послідовну обробку контейнера за допомогою методів, що використовувались для паралельної обробки та
 * забезпечити вимірювання часу їх роботи.
 * 3. Порівняти час паралельної і послідовної обробки та зробити висновки про ефективність розпаралелювання.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListContainer<Book> library = generateLibrary(20_000);

        Thread thread1 = new Thread(() -> getAverageDate(library));
        Thread thread2 = new Thread(() -> countBooksAfterDate(library, 2000));
        Thread thread3 = new Thread(() -> countBooksByAuthorCount(library, 2));

        // Parallel execution of methods
        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
        }

        long end = System.currentTimeMillis();
        double parallelTime = (end - start) / 1_000d;
        System.out.println("Parallel execution time = " + parallelTime + "s");

        // Sequential execution of methods
        start = System.currentTimeMillis();

        getAverageDate(library);
        countBooksAfterDate(library, 2000);
        countBooksByAuthorCount(library, 2);

        end = System.currentTimeMillis();
        double sequentialTime = (end - start) / 1_000d;
        System.out.println("Sequential execution time = " + sequentialTime + "s\n");

        // Comparison of results
        System.out.printf("Parallel execution is %.1f times faster than sequential execution", sequentialTime / parallelTime);
    }

    /**
     * Gets average date from all books in the library
     * @param library list of books
     * @return average date
     */
    public static int getAverageDate(LinkedListContainer<Book> library) {
        int sum = 0;

        for (Book book : library) {
            sum += book.getPublicationDate();
        }

        return sum / library.size();
    }

    /**
     * Counts books that bigger than concrete year
     * @param library list of books
     * @param year year after which start to count
     * @return number of books, date of which start after specified date
     */
    public static int countBooksAfterDate(LinkedListContainer<Book> library, int year) {
        int counter = 0;

        for (Book book : library) {
            if (book.getPublicationDate() > year)
                counter++;
        }

        return counter;
    }

    /**
     * Counts books that have concrete number of authors
     * @param library list of books
     * @param numberOfAuthors number of authors in the book
     * @return number of books that have concrete number of authors
     */
    public static int countBooksByAuthorCount(LinkedListContainer<Book> library, int numberOfAuthors) {
        int counter = 0;

        for (Book book : library) {
            if (book.getAuthors().length == numberOfAuthors)
                counter++;
        }

        return counter;
    }
}
