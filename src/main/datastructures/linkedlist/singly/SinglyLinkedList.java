package main.datastructures.linkedlist.singly;

import main.datastructures.linkedlist.CustomLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements CustomLinkedList<E> {

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
        if (e == null)
            throw new NullPointerException();
        head = new Node<>(e, head);
        if (isEmpty())
            tail = head;
        size++;
        return true;
    }

    @Override
    public boolean append(E e) {
        return isEmpty() ? prepend(e) : linkAfter(e, tail);
    }

    private boolean linkAfter(E e, Node<E> pred) {
        if (e == null)
            throw new NullPointerException();
        pred.next = new Node<>(e, pred.next);
        if (pred == tail)
            tail = pred.next;
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
        Node<E> pred = findNode(index - 1);
        linkAfter(e, pred);
    }

    private Node<E> findNode(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private boolean isInsertOutOfBounds(int index) {
        return index < 0 || index > size;
    }

    @Override
    public E set(int index, E e) {
        if (e == null)
            throw new NullPointerException();
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        Node<E> node = findNode(index);
        E oldValue = node.value;
        node.value = e;
        return oldValue;
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
        int index = -1;
        int i = 0;
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(e))
                index = i;
            i++;
        }
        return index;
    }

    @Override
    public E get(int index) {
        if (isSetIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException();
        if (index == size - 1)
            return getLast();
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
        Node<E> pred = findNode(index - 1);
        E removed = pred.next.value;
        unlinkAfter(pred);
        return removed;
    }

    private void unlinkAfter(Node<E> pred) {
        Node<E> succ = pred.next;
        pred.next = succ.next;
        if (succ == tail)
            tail = pred;
        size--;
    }

    @Override
    public boolean remove(E e) {
        if (e == null)
            throw new NullPointerException();
        if (isEmpty())
            throw new NoSuchElementException();
        if (head.value.equals(e)) {
            removeFirst();
            return true;
        }
        int index = indexOf(e);
        if (index != -1) {
            Node<E> pred = findNode(index - 1);
            unlinkAfter(pred);
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        E removed = head.value;
        head = head.next;
        if (size == 1)
            tail = null;
        size--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (size == 1) {
            return removeFirst();
        }
        E removed = tail.value;
        Node<E> pred = findNode(size - 2);
        unlinkAfter(pred);
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
