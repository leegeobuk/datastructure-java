package main.datastructures.linkedlist;

import main.datastructures.CustomCollection;

public interface CustomLinkedList<E> extends CustomCollection<E> {

    boolean append(E e);

    boolean prepend(E e);

    void insert(int index, E e);

    E set(int index, E e);

    int indexOf(E e);

    int lastIndexOf(E e);

    E get(int index);

    E getFirst();

    E getLast();

    E removeAt(int index);

    boolean remove(E e);

    E removeFirst();

    E removeLast();
}
