package ua.khpi.oop.khelemendyk13.test;

import org.junit.jupiter.api.*;
import ua.khpi.oop.khelemendyk13.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.khpi.oop.khelemendyk13.Main.*;

public class AlgorithmTest {
    private static LinkedListContainer<Book> library;

    @BeforeAll
    static void setup() {
        library = new LinkedListContainer<>();
        library.add(new Book("311-575-979995-8", "Robinson Crusoe", new String[] {"Й. Й. Булгаков", "М. Ю. Лермонтов"}, "Берлин", "Экшн", 1970));
        library.add(new Book("321-665-989795-8", "Маленький принц", new String[] {"Джек Лондон"}, "Одесса", "Лирика", 1914));
        library.add(new Book("123-456-789012-3", "Девять рассказов", new String[] {"Ричард Брэнсон", "Джером Сэлинджер"}, "Харьков", "Роман", 1930));
        library.add(new Book("311-575-979995-8", "Мастер и Маргарита", new String[] {"Ричард Брэнсон", "Лев Толстой"}, "Варшава", "Эпос", 2001));
        library.add(new Book("987-643-234567-5", "Приступление и наказание", new String[] {"Лев Толстой", "Ричард Брэнсон"}, "Москва", "Лирика", 2008));
        library.add(new Book("654-123-568412-5", "Жага до життя", new String[] {"Джек Лондон"}, "Київ", "Драма", 1910));
        library.add(new Book("321-665-939191-4", "Над пропастью во ржи", new String[] {"Джером Сэлинджер"}, "Вена", "Роман", 2022));
        library.add(new Book("987-643-234567-1", "Приключения Тома Сойера", new String[] {"Марк Твен"}, "Харьков", "Роман", 1876));
        library.add(new Book("921-665-999096-1", "Быть или не быть", new String[] {"Марк Твен", "Антуан Экзюпери"}, "Нью-йорк", "Эпос", 2010));
        library.add(new Book("365-987-246987-2", "The Wolf of Wall Street", new String[] {"Александр Дюма"}, "Львов", "Проза", 1996));
    }

    @Test
    void testGetAverageDate() {
        int expectedAverageDate = 1963;
        int actual = getAverageDate(library);

        assertEquals(expectedAverageDate, actual);
    }

    @Test
    void testCountBooksAfterDate() {
        int expected = 4;
        int actual = countBooksAfterDate(library, 2000);

        assertEquals(expected, actual);
    }

    @Test
    void testCountBooksByAuthorCount() {
        int expected = 5;
        int actual = countBooksByAuthorCount(library, 2);

        assertEquals(expected, actual);
    }
}
