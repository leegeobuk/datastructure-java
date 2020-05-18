package main.datastructures.queue;

import main.datastructures.CustomCollection;

public interface CustomQueue<E> extends CustomCollection<E> {
    boolean enqueue(E e);

    E dequeue();

    E peek();
}
