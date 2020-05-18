package main.datastructures.stack;

public interface CustomStack<E> {
    boolean empty();

    int size();

    void clear();

    E peek();

    E push(E e);

    E pop();

    int search(E e);
}
