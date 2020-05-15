package main.datastructures.linkedlist.doubly;

import main.datastructures.linkedlist.CustomLinkedList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> implements CustomLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean append(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty()) {
            tail = new Node<>(e, null, null);
            head = tail;
        } else {
            tail.next = new Node<>(e, tail, null);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean prepend(E e) {
        return true;
    }

    @Override
    public void insert(int index, E e) {

    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        return -1;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public E removeAt(int index) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        E removed = head.value;
        if (size == 1) {
            clear();
            return removed;
        }
        head = head.next;
        head.prev = null;
        size--;
        return removed;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    static class Node<E> {
        private E value;
        private Node<E> prev;
        private Node<E> next;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
