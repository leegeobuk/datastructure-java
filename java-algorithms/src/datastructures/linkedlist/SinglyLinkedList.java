package datastructures.linkedlist;

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
        E old = cur.value;
        cur.value = e;
        return old;
    }

    private boolean isSetIndexOutOfBounds(int index) {
        return index < 0 || index >= size;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public int indexOf(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        int index = 0;
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(e))
                return index;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        int index = -1;
        int i = 0;
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(e))
                index = i;
            i++;
        }
        return index;
    }

    public E get(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public E remove(int index) {
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (isEmpty())
            throw new NoSuchElementException();
        Node<E> cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        E removed = cur.next.value;
        cur.next = cur.next.next;
        size--;
        return removed;
    }

    public boolean remove(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty())
            throw new NoSuchElementException();
        for (Node<E> cur = head; cur.next != null; cur = cur.next) {
            if (cur.next.value.equals(e)) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public E removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        E removed = head.value;
        if (size == 1) {
            clear();
            return removed;
        }
        head = head.next;
        return removed;
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
