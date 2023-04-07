package ua.khpi.oop.khelemendyk15;

import java.util.*;

import static ua.khpi.oop.khelemendyk15.GeneratorUtil.generateLibrary;

/**
 * Завдання:
 * 1. Забезпечити обробку колекції об'єктів: додавання, видалення, пошук, сортування
 * згідно розділу Прикладні задачі л.р. №10.
 * 2. Продемонструвати розроблену функціональність в діалоговому та автоматичному режимах
 * за результатом обробки параметрів командного рядка.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {

        List<Book> library = new ArrayList<>();

        if (args.length != 0 && args[0].equals("-auto")) {
            library = generateLibrary(10);
        }

        Menu dialogMenu = new Menu(library);
        dialogMenu.startMenu();
    }
}
