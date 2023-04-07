package ua.khpi.oop.khelemendyk09;

/**
 * Завдання: Створити власний клас-контейнер, що параметризується (Generic Type), на основі зв'язних списків
 * для реалізації колекції domain-об’єктів лабораторної роботи №7.
 * Для розроблених класів-контейнерів забезпечити можливість використання їх об'єктів у циклі foreach
 * в якості джерела даних.
 *
 * @author Khelemendyk D.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListContainer<Integer> list = new LinkedListContainer<>();

        System.out.println("Add 1, 2 and 3 to the container: ");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println();

        System.out.println("Add 4 to the first position to the container: ");
        list.add(0, 4);
        System.out.println(list);
        System.out.println();

        System.out.println("Set the second element to the value of 10");
        list.set(1, 10);
        System.out.println();

        System.out.println("Get the second element from the container: ");
        System.out.println(list.get(1));
        System.out.println();

        System.out.println("Current container");
        System.out.println(list);
        System.out.println();

        System.out.println("Remove 10 and the first element from container");
        list.remove(Integer.valueOf(10));
        list.remove(0);
        System.out.println();

        System.out.println("Print container by foreach loop");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println();

        System.out.println("Check size of the container: ");
        System.out.println(list.size());
        System.out.println();

        System.out.println("Check if the container contains 10");
        System.out.println(list.contains(10));
        System.out.println();

        System.out.println("Check if the container contains 3");
        System.out.println(list.contains(3));
        System.out.println();

        System.out.println("Use toArray() method and print the first element of the array");
        Object[] objects = list.toArray();
        System.out.println(objects[0]);
        System.out.println();

        System.out.println("Check if the container is empty");
        System.out.println(list.isEmpty());
        System.out.println();

        System.out.println("Clear the container");
        list.clear();
        System.out.println("Check if the container is empty");
        System.out.println(list.isEmpty());
    }
}
