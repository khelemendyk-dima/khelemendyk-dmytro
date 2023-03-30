package ua.khpi.oop.khelemendyk13;

import ua.khpi.oop.khelemendyk14.Book;
import ua.khpi.oop.khelemendyk14.LinkedListContainer;

import java.util.Random;

/**
 * GeneratorUtil class. Generates books from reserved data
 *
 * @author Khelemendyk Dmytro
 */
public class GeneratorUtil {
    private static final String[] ISBNs = new String[] {
                            "123-456-789012-3", "654-123-568412-5",
                            "321-665-989795-8", "354-174-939191-4",
                            "921-665-999096-1", "311-575-979995-8",
                            "987-643-234567-5", "456-852-635478-1",
                            "365-987-246987-2", "254-124-536879-4"};
    private static final String[] bookNames = new String[] {
                            "Быть или не быть", "Жага до життя",
                            "Мастер и Маргарита", "Над пропастью во ржи",
                            "Девять рассказов", "Маленький принц",
                            "Приключения Тома Сойера", "The Wolf of Wall Street",
                            "Приступление и наказание", "Robinson Crusoe"};
    private static final String[] bookAuthors = new String[] {
                            "Марк Твен",          "Джек Лондон",
                            "Й. Й. Булгаков",     "Джером Сэлинджер",
                            "Антуан Экзюпери",    "А. С. Пушкин",
                            "М. Ю. Лермонтов",    "Лев Толстой",
                            "Джордан Белфорт",    "Ричард Брэнсон",
                            "Артур Конан Дойл",   "Александр Дюма"};
    private static final String[] productions = new String[] {
                            "Киев",    "Москва",   "Вена",
                            "Лондон",  "Львов",    "Париж",
                            "Харьков", "Нью-йорк", "Питер",
                            "Варшава", "Берлин",   "Одесса"};
    private static final String[] genres = new String[] {
                            "Драма", "Роман",   "Проза",
                            "Экшн",  "Комедия", "Рассказ",
                            "Эпос",  "Лирика",  "Триллер"};

    /**
     * Generates library. Gets random data from reserved data
     * @param numberOfBooks number of books to generate
     * @return list of books
     */
    public static LinkedListContainer<Book> generateLibrary(int numberOfBooks) {
        LinkedListContainer<Book> library = new LinkedListContainer<>();
        Random rdm = new Random();

        for (int i = 0; i < numberOfBooks; i++) {
            String ISBN = ISBNs[rdm.nextInt(ISBNs.length)];
            String name = bookNames[rdm.nextInt(bookNames.length)];
            String[] authors = getAuthors(rdm.nextInt(1, 4));
            String production = productions[rdm.nextInt(productions.length)];
            String genre = genres[rdm.nextInt(genres.length)];
            int date = rdm.nextInt(1900, 2023);

            library.add(new Book(ISBN, name, authors, production, genre, date));
        }

        return library;
    }

    /**
     * Gets authors from reserved data
     * @param numberOfAuthors number of authors for a book
     * @return array of authors
     */
    private static String[] getAuthors(int numberOfAuthors) {
        if (numberOfAuthors <= 0)
            return null;

        String[] authors = new String[numberOfAuthors];
        Random random = new Random();

        for (int i = 0; i < numberOfAuthors; i++) {
            authors[i] = bookAuthors[random.nextInt(bookAuthors.length)];
        }

        return authors;
    }
}