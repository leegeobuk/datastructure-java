package main.datastructures.queue;

import main.datastructures.linkedlist.doubly.DoublyLinkedList;

public class Queue<E> implements CustomQueue<E> {

    private DoublyLinkedList<E> linkedList = new DoublyLinkedList();

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public boolean enqueue(E e) {
        return linkedList.append(e);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
