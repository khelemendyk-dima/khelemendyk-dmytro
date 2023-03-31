package ua.khpi.oop.khelemendyk12.test;

import org.junit.jupiter.api.*;
import ua.khpi.oop.khelemendyk12.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private static Menu menu;
    private static LinkedListContainer<Book> library;

    @BeforeAll
    static void setup() {
        library = new LinkedListContainer<>();
        library.add(new Book());
        library.add(new Book("654-123-568412-5", "Жага до життя", new String[] {"Джек Лондон"}, "Київ", "Драма", 1910));
        library.add(new Book("321-665-989795-8", "Мастер и Маргарита", new String[] {"Й. Й. Булгаков"}, "Москва", "Роман", 2020));
        library.add(new Book("321-665-939191-4", "Над пропастью во ржи", new String[] {"Джером Сэлинджер"}, "Вена", "Роман", 2022));
        library.add(new Book("321-665-999096-1", "Девять рассказов", new String[] {"Джером Сэлинджер"}, "Львов", "Рассказ", 2021));
        library.add(new Book("311-575-979995-8", "Маленький принц", new String[] {"Й. Й. Экзюпери"}, "Париж", "Проза", 2006));
        library.add(new Book("987-643-234567-1", "Приключения Тома Сойера", new String[] {"Марк Твен"}, "Харьков", "Роман", 1876));
    }

    @BeforeEach
    void initEach() {
        menu = new Menu(library);
    }

    @Test
    void testFindBooksByFilter() {
        LinkedListContainer<Book> expected = new LinkedListContainer<>();
        expected.add(new Book("321-665-989795-8", "Мастер и Маргарита", new String[] {"Й. Й. Булгаков"}, "Москва", "Роман", 2020));

        LinkedListContainer<Book> actual = menu.findBooksByFilter();
        assertIterableEquals(expected, actual);
    }

    @Test
    void testChangedDateFindBooksByFilter() {
        LinkedListContainer<Book> expected = new LinkedListContainer<>();
        expected.add(new Book("321-665-989795-8", "Мастер и Маргарита", new String[] {"Й. Й. Булгаков"}, "Москва", "Роман", 2020));
        expected.add(new Book("311-575-979995-8", "Маленький принц", new String[] {"Й. Й. Экзюпери"}, "Париж", "Проза", 2006));

        menu.setPublicationDateRegex(2000);

        LinkedListContainer<Book> actual = menu.findBooksByFilter();
        assertIterableEquals(expected, actual);
    }

    @Test
    void testChangedAuthorFindBooksByFilter() {
        LinkedListContainer<Book> expected = new LinkedListContainer<>();
        expected.add(new Book("321-665-939191-4", "Над пропастью во ржи", new String[] {"Джером Сэлинджер"}, "Вена", "Роман", 2022));
        expected.add(new Book("321-665-999096-1", "Девять рассказов", new String[] {"Джером Сэлинджер"}, "Львов", "Рассказ", 2021));

        menu.setAuthorRegex("Джером Сэлинджер");

        LinkedListContainer<Book> actual = menu.findBooksByFilter();

        assertIterableEquals(expected, actual);
    }

    @Test
    void testChangedISBNFindBooksByFilter() {
        LinkedListContainer<Book> expected = new LinkedListContainer<>();
        expected.add(new Book("321-665-999096-1", "Девять рассказов", new String[] {"Джером Сэлинджер"}, "Львов", "Рассказ", 2021));
        expected.add(new Book("311-575-979995-8", "Маленький принц", new String[] {"Й. Й. Экзюпери"}, "Париж", "Проза", 2006));

        menu.setIsbnRegex("999");
        menu.setAuthorRegex("");
        menu.setPublicationDateRegex(2000);

        LinkedListContainer<Book> actual = menu.findBooksByFilter();

        assertIterableEquals(expected, actual);
    }


}
