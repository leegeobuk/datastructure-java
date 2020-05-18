package main.datastructures.stack;

public interface CustomStack<E> {
    int size();

    boolean empty();

    void clear();

    E peek();

    E push(E e);

    E pop();

    int search(E e);
}
