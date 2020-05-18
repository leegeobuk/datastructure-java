package main.datastructures.stack;

import main.datastructures.linkedlist.doubly.DoublyLinkedList;

public class Stack<E> implements CustomStack<E> {

    private DoublyLinkedList<E> linkedList = new DoublyLinkedList<>();

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public E peek() {
        return linkedList.getLast();
    }

    @Override
    public E push(E e) {
        linkedList.append(e);
        return e;
    }

    @Override
    public E pop() {
        return linkedList.removeLast();
    }

    /**
     * Returns the 1-based position where an element is on this stack.
     * If the element e occurs as an item in this stack, this
     * method returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack; the topmost item on the
     * stack is considered to be at distance 1. The equals
     * method is used to compare e to the items in this stack.
     *
     * @param   e    the desired element
     * @return  the 1-based position from the top of the stack where
     *          the element is located; the return value -1
     *          indicates that the element is not on the stack
     */
    @Override
    public int search(E e) {
        int index = linkedList.lastIndexOf(e);
        return index >= 0 ? (linkedList.size() - index) : -1;
    }
}
