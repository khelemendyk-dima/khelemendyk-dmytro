package ua.khpi.oop.khelemendyk07;

import java.util.ArrayList;
import java.util.List;

/**
 * Завдання: Використання об'єктно-орієнтованого підходу для розробки
 * об'єкта предметної (прикладної) галузі.
 * 4. Бібліотека
 * Дані про книгу: ISBN; назва; автори (кількість не обмежена);
 * видавництво; жанр; дата видання.
 *
 * @author Khelemendyk D.
 */

public class Main {
    /**
     * Точка входу консольної програми.
     *
     * @param args параметри командного рядка
     */
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();

        library.add(new Book("978-316-148410-0",
                             "Приключения Тома Сойера",
                    new String[] { "Марк Твен" },
                            "Харьков",
                             "Роман",
                      1876));

        library.add(new Book("978-316-148410-1",
                            "Рога и копыта",
                   new String[] { "Джек Лондон", "Вася Петькин" },
                           "Киев",
                            "Драма",
                     1901));

        System.out.println("Первая книга:");
        System.out.println(library.get(0));
        System.out.println("\nВторая книга:");
        System.out.println(library.get(1));
    }
}
