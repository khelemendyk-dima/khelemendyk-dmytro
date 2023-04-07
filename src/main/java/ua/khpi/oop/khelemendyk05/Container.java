package ua.khpi.oop.khelemendyk05;

import java.util.*;

/**
 * Завдання: Розробити клас-контейнер, що ітерується для збереження початкових
 * даних завдання л.р. №3 у вигляді масиву рядків з можливістю додавання,
 * видалення і зміни елементів.
 *
 * @author Khelemendyk D.
 */

public class Container implements Iterable<String> {
    private String[] texts;

    public Container() {
        texts = new String[0];
    }

    /**
     * Повертає рядок за індексом, якщо він входить в інтервал.
     * @param index позиція елемента.
     * @return елемент масива.
     */
    public String get(int index) {
        if (index < 0 || index > texts.length - 1)
            throw new IllegalArgumentException();

        return texts[index];
    }

    /**
     * Змінює рядок за індексом на іниший, якщо позиція входить в
     * межі масиву та новий рядок не дорівнює null.
     * @param index позиція елемента, котрий потрібно замінити.
     * @param text рядок, на який буде замінено інший.
     * @return рядок, який будуть заміняти.
     */
    public String set(int index, String text) {
        if (index < 0 || index > texts.length - 1
                || text == null)
            throw new IllegalArgumentException();

        String prevText = texts[index];
        texts[index] = text;

        return prevText;
    }

    /**
     * Додавання елемента у кінець контейнера.
     * @param string рядок, який потрібно додати.
     */
    public void add(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        String[] newTexts = new String[size() + 1];
        System.arraycopy(texts, 0, newTexts, 0, size());
        newTexts[size()] = string;
        texts = newTexts;
    }

    /**
     * Видаляє перший випадок вказаного елемента з контейнера.
     * @param string елемент, котрий потрібно видалити.
     * @return true - якщо елемент був видалений, інакше - false.
     */
    public boolean remove(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        if (!contains(string))
            return false;

        String[] newTexts = new String[size() - 1];
        int index = 0;

        while (texts[index].compareTo(string) != 0) {
            newTexts[index] = texts[index];
            index++;
        }
        System.arraycopy(texts, index + 1, newTexts, index, size() - index - 1);
        texts = newTexts;

        return true;
    }

    /**
     * Видаляє всі елементи з контейнеру.
     */
    public void clear() {
        texts = new String[0];
    }

    /**
     * Перевіряє чи наявний елемент в контейнері.
     * @param string рядок, наявність якого потрібно перевірити.
     * @return повертає true, якщо контейнер містить вказаний елемент,
     * інакше - false.
     */
    public boolean contains(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        boolean isContain = false;

        for (int i = 0; i < size(); i++) {
            if (texts[i].compareTo(string) == 0) {
                isContain = true;
                break;
            }
        }

        return isContain;
    }

    /**
     * Перевіряє наявність переданих елементів контейнера в контейнері.
     * @param container контейнер, наявність елементів якого потрібно перевірити.
     * @return true якщо всі = елементи заданного контейнера наявні в конйтенері,
     * - інакше false.
     */
    public boolean containsAll(Container container) {
        for (int i = 0; i < container.size(); i++) {
            if (!contains(container.get(i)))
                return false;
        }
        return true;
    }

    /**
     * Повертає ітератор. Створенний анонімний клас Iterator та визначені його
     * абстарктні методи.
     * @return ітератор відповідно до Interface Iterable.
     */
    public Iterator<String> iterator() { return new Iterator<>() {
        int cursor;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public String next() {
            int i = cursor;
            if (i >= size())
                throw new NoSuchElementException();
            cursor = i + 1;
            return texts[lastRet = i];
        }
        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                Container.this.remove(get(lastRet));
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }; }

    /**
     * Визначає розмір контейнеа.
     * @return розмір контейнера.
     */
    public int size() { return texts.length; }

    /**
     * Повертає масив, що містить всі елементи у контейнері.
     * @return масив об'єктів.
     */
    public Object[] toArray() { return texts;}

    /**
     * Повертає вміст контейнера у вигляді рядка.
     * @return рядок з всіма елементами контейнера, перерахованих через кому.
     */
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < size(); i++) {
            sj.add(texts[i]);
        }
        return sj.toString();
    }
}
