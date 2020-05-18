package main.datastructures;

public interface CustomCollection<E> {
    void clear();

    boolean isEmpty();

    int size();

    boolean contains(E e);
}
