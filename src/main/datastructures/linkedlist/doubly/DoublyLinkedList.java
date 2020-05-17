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
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty()) {
            head = new Node<>(e, null, null);
            tail = head;
        } else {
            head.prev = new Node<>(e, null, head);
            head = head.prev;
        }
        size++;
        return true;
    }

    @Override
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
        Node<E> cur;
        Node<E> node;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node = new Node<>(e, cur, cur.next);
            cur.next = node;
            node.next.prev = node;
        } else {
            cur = tail;
            for (int i = 0; i < (size - 1) - index; i++) {
                cur = cur.prev;
            }
            node = new Node<>(e, cur.prev, cur);
            cur.prev = node;
            node.prev.next = node;
        }
        size++;
    }

    private boolean isInsertOutOfBounds(int index) {
        return index < 0 || index > size;
    }

    @Override
    public E set(int index, E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        Node<E> cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < (size - 1) - index; i++) {
                cur = cur.prev;
            }
        }
        E old = cur.value;
        cur.value = e;
        return old;
    }

    private boolean isSetIndexOutOfBounds(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
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

    @Override
    public int lastIndexOf(E e) {
        return -1;
    }

    @Override
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

    @Override
    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.value;
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
