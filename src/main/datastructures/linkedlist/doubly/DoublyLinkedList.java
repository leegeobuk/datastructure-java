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
    public boolean prepend(E e) {
        return isEmpty() ? append(e) : linkBefore(e, head);
    }

    private boolean linkBefore(E e, Node<E> succ) {
        if (e == null)
            throw new NullPointerException();
        Node<E> pred = succ.prev;
        Node<E> node = new Node<>(e, pred, succ);
        succ.prev = node;
        if (succ != head)
            pred.next = node;
        else
            head = node;
        size++;
        return true;
    }

    @Override
    public boolean append(E e) {
        if (e == null)
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
    public void insert(int index, E e) {
        if (isInsertOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            prepend(e);
            return;
        } else if (index == size) {
            append(e);
            return;
        }
        Node<E> cur = findNode(index);
        linkBefore(e, cur);
    }

    private Node<E> findNode(int index) {
        return index < (size >> 1) ? findNodeFromStart(index) : findNodeFromEnd(index);
    }

    private Node<E> findNodeFromStart(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private Node<E> findNodeFromEnd(int index) {
        Node<E> cur = tail;
        for (int i = 0; i < (size - 1) - index; i++) {
            cur = cur.prev;
        }
        return cur;
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
        Node<E> node = findNode(index);
        E old = node.value;
        node.value = e;
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
        if (e == null)
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
        if (e == null)
            throw new NullPointerException();
        int index = size - 1;
        for (Node<E> cur = tail; cur != null; cur = cur.prev) {
            if (cur.value.equals(e))
                return index;
            index--;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        return findNode(index).value;
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
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E removed = cur.value;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return removed;
    }

    @Override
    public boolean remove(E e) {
        if (Objects.isNull(e))
            throw new NullPointerException();
        if (isEmpty())
            throw new NoSuchElementException();
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(e)) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                size--;
                return true;
            }
        }
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
        if (isEmpty())
            throw new NoSuchElementException();
        E removed = tail.value;
        if (size == 1) {
            clear();
            return removed;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            sb.append(cur.toString()).append(cur.next != null ? " -> " : "");
        }
        sb.append("]");
        return sb.toString();
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
