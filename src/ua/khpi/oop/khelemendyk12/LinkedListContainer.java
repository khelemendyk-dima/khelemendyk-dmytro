package ua.khpi.oop.khelemendyk12;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * LinkedListContainer is a container that implements linked list and have methods to operate with collection.
 * @param <E> the type of elements in this container
 *
 * @author Khelemendyk Dmytro
 * @version 1.0
 */
public class LinkedListContainer<E> implements Iterable<E>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private transient int size = 0;
    
    /**
     * Pointer to first node.
     */
    private transient Node<E> first;

    /**
     * Pointer to last node.
     */
    private transient Node<E> last;

    /**
     * This is Node class that used in LinkedListContainer as pointer for first and last node of the container
     * @param <E> the type of item
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Adds element in the end of the container
     * @param element element that need to be added
     */
    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Adds element in the index position is its valid
     * @param index the index of the element to add
     * @param element element that need to be added
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        
        if (index == size) {
            add(element);
        } else {
            Node<E> nextNode = findNode(index);
            final Node<E> prevNode = nextNode.prev;
            final Node<E> newNode = new Node<>(prevNode, element, nextNode);
            nextNode.prev = newNode;
            if (prevNode == null)
                first = newNode;
            else
                prevNode.next = newNode;
            size++;
        }
    }

    /**
     * Removes the first occurrence of the specified element from this container,
     * if it is present. If container does not contain the element, it is
     * unchanged.
     * @param object element to be removed from this list, if present
     * @return true if this container contained the specified element
     */
    public boolean remove(Object object) {
        if (object == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (object.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * Checks index position. If its valid then removes element from container
     * @param index the index of the element to remove
     */
    public void remove(int index) {
        checkPositionIndex(index);
        unlink(findNode(index));
    }

    /**
     * Unlinks non-null node x.
     * @param x node that need to be unlinked
     */
    private void unlink(Node<E> x) {
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        checkPositionIndex(index);

        Node<E> x = findNode(index);

        return x.item;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public E set(int index, E element) {
        checkPositionIndex(index);

        Node<E> x = findNode(index);
        E oldValue = x.item;
        x.item = element;

        return oldValue;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     * @param index index of the element to find node
     * @return the (non-null) Node at the specified element index.
     */
    private Node<E> findNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    /**
     * Checks if the index is valid
     * @param index index of element in the container
     */
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * @return number of elements in the container
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from this list. The list will be empty after this call returns.
     */
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * @return true if container is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the container contains the specified element
     * @param o element whose presence in this list is to be tested
     * @return true if this container contains the specified element.
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns the lowest index i of the first occurrence of the specified element or -1 if there is no such index.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this container,
     * or -1 if this container does not contain the element
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }

        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int cursor = 0;
            int lastRet = -1;

            @Override
            public boolean hasNext() {
                return cursor != size();
            }

            @Override
            public E next() {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            }
        };
    }
    
    /**
     * Swaps elements in the container. If element wasn't found then nothing will happen
     * @param x first element
     * @param y second element
     */
    public void swap(E x, E y) {
        if (first == null || x == y) {
            return;
        }

        Node<E> nodeX = first;
        Node<E> nodeY = first;

        while (nodeX != null && nodeX.item != x) {
            nodeX = nodeX.next;
        }
        while (nodeY != null && nodeY.item != y) {
            nodeY = nodeY.next;
        }

        if (nodeX != null && nodeY != null) {
            nodeX.item = y;
            nodeY.item = x;
        }
    }

    /**
     * @return an array containing all elements in this container in proper sequence (from first to last element).
     */
    public Object[] toArray() {
        Object[] result = new Object[size];

        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        return result;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(node.item.toString());
            node = node.next;
        }

        return stringJoiner.toString();
    }
}
