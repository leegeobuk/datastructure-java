package main.datastructures.linkedlist;

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
        if (index == 0) {
            prepend(e);
            return;
        } else if (index == size) {
            append(e);
            return;
        }
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
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == size - 1)
            return getLast();
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.value;
    }

    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.value;
    }

    public E remove(int index) {
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();
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
        if (head.value.equals(e)) {
            removeFirst();
            return true;
        }
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
        size--;
        return removed;
    }

    public E removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (size == 1) {
            return removeFirst();
        }
        Node<E> cur = head;
        for (int i = 0; i < size - 2; i++) {
            cur = cur.next;
        }
        E removed = tail.value;
        tail = cur;
        size--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(head.toString());
        for (Node<E> cur = head.next; cur != null; cur = cur.next) {
            sb.append(" -> ").append(cur.toString());
        }
        return sb.toString();
    }

    static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
