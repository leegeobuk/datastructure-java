package main.datastructures.linkedlist;

public class DoublyLinkedList<E> implements CustomLinkedList<E> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean append(E e) {
        return false;
    }

    @Override
    public boolean prepend(E e) {
        return false;
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
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
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
        return null;
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
        return null;
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
