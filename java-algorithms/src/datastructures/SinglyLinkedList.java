package datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean append(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty()) {
            tail = new Node<>(e, null);
            head = tail;
        } else {
            tail.next = new Node<>(e, null);
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean prepend(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty()) {
            head = new Node<>(e, null);
            tail = head;
        } else {
            head = new Node<>(e, head);
        }
        size++;
        return true;
    }

    public void insert(int index, E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isInsertOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == 0)
            prepend(e);
        else if (index == size)
            append(e);
        Node<E> cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = new Node<>(e, cur.next);
        size++;
    }

    private boolean isInsertOutOfBounds(int index) {
        return index < 0 || index > size;
    }

    public E set(int index, E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (isEmpty())
            throw new NoSuchElementException();
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E prev = cur.value;
        cur.value = e;
        return prev;
    }

    private boolean isSetIndexOutOfBounds(int index) {
        return index < 0 || index >= size;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (Objects.isNull(o))
            throw new NullPointerException();
        int index = 0;
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(o))
                return index;
            index++;
        }
        return -1;
    }

    public E get(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
