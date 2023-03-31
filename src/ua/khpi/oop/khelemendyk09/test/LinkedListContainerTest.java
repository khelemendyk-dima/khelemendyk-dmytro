package ua.khpi.oop.khelemendyk09.test;

import org.junit.jupiter.api.*;
import ua.khpi.oop.khelemendyk09.LinkedListContainer;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListContainerTest {
    private static LinkedListContainer<Integer> integers;

    @BeforeEach
    void initEach() {
        integers = new LinkedListContainer<>();
    }

    @Test
    void testSimpleAdd() {
        integers.add(1);
        integers.add(3);
        integers.add(2);

        assertEquals(3, integers.size());
        assertIterableEquals(Arrays.asList(1, 3, 2), integers);
    }

    @Test
    void testAddToConcretePosition() {
        integers.add(0, 1);
        integers.add(0, 2);
        integers.add(2, 3);

        assertEquals(3, integers.size());
        assertIterableEquals(Arrays.asList(2, 1, 3), integers);
    }

    @Test
    void testWrongPositionAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> integers.add(5, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.add(-5, 1));
    }
    @Test
    void testRemoveByObject() {
        integers.add(1);
        integers.add(3);
        integers.add(2);

        integers.remove(Integer.valueOf(1));

        assertEquals(2, integers.size());
        assertIterableEquals(Arrays.asList(3, 2), integers);

        integers.remove(Integer.valueOf(2));

        assertEquals(1, integers.size());
        assertIterableEquals(List.of(3), integers);

        integers.remove(Integer.valueOf(3));

        assertEquals(0, integers.size());
    }

    @Test
    void testRemoveByIndex() {
        integers.add(1);
        integers.add(3);
        integers.add(2);

        integers.remove(1);

        assertEquals(2, integers.size());
        assertIterableEquals(Arrays.asList(1, 2), integers);

        integers.remove(0);

        assertEquals(1, integers.size());
        assertIterableEquals(List.of(2), integers);

        integers.remove(0);

        assertEquals(0, integers.size());
    }

    @Test
    void testWrongIndexRemove() {
        assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(-5));
    }

    @Test
    void testGet() {
        integers.add(1);
        integers.add(3);
        integers.add(2);

        assertEquals(1, integers.get(0));
        assertEquals(2, integers.get(2));
        assertEquals(3, integers.get(1));
    }

    @Test
    void testWrongIndexGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> integers.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.get(-5));
    }

    @Test
    void testSet() {
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(5);

        integers.set(0, 10);
        assertIterableEquals(Arrays.asList(10, 3, 2, 5), integers);

        integers.set(1, 9);
        assertIterableEquals(Arrays.asList(10, 9, 2, 5), integers);

        integers.set(3, 7);
        assertIterableEquals(Arrays.asList(10, 9, 2, 7), integers);
    }

    @Test
    void testWrongSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> integers.set(5, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.set(-5, 1));
    }

    @Test
    void testSize() {
        assertEquals(0, integers.size());

        integers.add(1);
        assertEquals(1, integers.size());

        integers.add(1);
        integers.add(1);
        integers.add(1);

        assertEquals(4, integers.size());
    }

    @Test
    void testClear() {
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(5);

        integers.clear();

        assertEquals(0, integers.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(integers.isEmpty());

        integers.add(1);
        assertFalse(integers.isEmpty());
    }

    @Test
    void testContains() {
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(5);

        assertTrue(integers.contains(1));
        assertTrue(integers.contains(2));
        assertTrue(integers.contains(5));
        assertFalse(integers.contains(4));
    }

    @Test
    void testIndexOf() {
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(5);

        assertEquals(0, integers.indexOf(1));
        assertEquals(1, integers.indexOf(3));
        assertEquals(3, integers.indexOf(5));
        assertEquals(-1, integers.indexOf(50));
    }

    @Test
    void testNotEmptyHasNext() {
        integers.add(1);
        assertTrue(integers.iterator().hasNext());
    }

    @Test
    void testEmptyHasNext() {
        assertFalse(integers.iterator().hasNext());
    }

    @Test
    void testNext() {
        integers.add(1);
        integers.add(2);
        Iterator<Integer> iterator = integers.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }

    @Test
    void testNullPointerExceptionNext() {
        assertThrows(NullPointerException.class, () -> integers.iterator().next());
    }

    @Test
    void testNextAndHasNext() {
        integers.add(1);
        Iterator<Integer> iterator = integers.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
