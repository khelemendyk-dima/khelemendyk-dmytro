package ua.khpi.oop.khelemendyk13;

import ua.khpi.oop.khelemendyk14.Book;
import ua.khpi.oop.khelemendyk14.LinkedListContainer;

import java.util.Scanner;

import static ua.khpi.oop.khelemendyk13.GeneratorUtil.generateLibrary;

/**
 * Завдання: продемонструвати можливість паралельної обробки елементів контейнера:
 * створити не менше трьох додаткових потоків, на яких викликати відповідні методи
 * обробки контейнера.
 * Забезпечити можливість встановлення користувачем максимального
 * часу виконання (таймаута) при закінченні якого обробка повинна припинятися
 * незалежно від того знайдений кінцевий результат чи ні.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListContainer<Book> library = generateLibrary(40_000);

        Thread averageDate = new Thread(new AverageDateThread(library));
        Thread booksAfterDate = new Thread(new BooksAfterDateThread(library, 2000));
        Thread booksByAuthorCount = new Thread(new BooksByAuthorCountThread(library, 2));

        long timeOut = getTimeOut();

        averageDate.start();
        booksAfterDate.start();
        booksByAuthorCount.start();

        if (timeOut != 0) {
            try {
                averageDate.join(timeOut);
            } catch (InterruptedException e) {
                System.out.println("Oops...Something go wrong...");
            }

            averageDate.interrupt();
            booksAfterDate.interrupt();
            booksByAuthorCount.interrupt();
        }
    }

    /**
     * Asks user to input time out
     * @return time out
     */
    private static long getTimeOut() {
        Scanner scanner = new Scanner(System.in);
        long timeOut;

        System.out.print("Set time out(sec): ");
        timeOut = scanner.nextLong();
        while (timeOut < 0) {
            System.out.println("Wrong time out. Time out must be bigger or equal 0.");
            System.out.print("Set time out(sec): ");
            timeOut = scanner.nextLong();
        }

        return timeOut * 1000L;
    }
}