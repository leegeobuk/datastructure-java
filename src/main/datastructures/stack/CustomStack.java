package main.datastructures.stack;

public interface CustomStack<E> {
    boolean empty();

    E peek();

    E pop();

    E push(E e);

    int search(E e);
}
