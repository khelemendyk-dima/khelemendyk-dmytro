package ua.khpi.oop.khelemendyk05;

import java.util.Arrays;

/**
 * Завдання: Розробити клас-контейнер, що ітерується для збереження початкових
 * даних завдання л.р. №3 у вигляді масиву рядків з можливістю додавання,
 * видалення і зміни елементів.
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
        Container c = new Container();

        System.out.println("Adding elements to container:");
        c.add("Hello world");
        c.add("How are you");
        c.add("I'm fine");
        System.out.println(c);

        System.out.println("\nSetting first element of container to new value:");
        c.set(0, "Who are you?");
        System.out.println(c);

        System.out.println("\nUsing of size() method:");
        System.out.println(c.size());

        System.out.println("\nUsing of contains() method of the value \"I'm fine\"");
        System.out.println(c.contains("I'm fine"));

        System.out.println("\nUsing of containsAll() method for two values \"Who are you?\" and \"I'm fine\":");
        Container testContainsAll = new Container();
        testContainsAll.add("Who are you?");
        testContainsAll.add("I'm fine");
        System.out.println(c.containsAll(testContainsAll));

        System.out.println("\nUsing iterator in while loop:");
        var it = c.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\nRemoving elements by iterator in for each loop:");
        for (String s : c)
            System.out.println(s);

        System.out.println("\nRemoving second element of the container \"How are you\":");
        c.remove("How are you");
        System.out.println(c);

        System.out.println("\nUsing of toArray() method:");
        Object[] o = c.toArray();
        System.out.println(Arrays.toString(o));

        System.out.println("\nUsing of clear() method (there is an empty string because container is empty):");
        c.clear();
        System.out.println(c);
    }
}
