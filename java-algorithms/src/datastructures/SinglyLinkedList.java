package datastructures;

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

    static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
