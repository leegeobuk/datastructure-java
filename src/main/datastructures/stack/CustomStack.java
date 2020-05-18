package main.datastructures.stack;

import main.datastructures.CustomCollection;

public interface CustomStack<E> extends CustomCollection<E> {
    E peek();

    E push(E e);

    E pop();

    int search(E e);
}
