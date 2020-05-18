package main.datastructures.queue;

import main.datastructures.linkedlist.doubly.DoublyLinkedList;

public class Queue<E> implements CustomQueue<E> {

    private DoublyLinkedList linkedList = new DoublyLinkedList();

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean enqueue(E e) {
        return false;
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
