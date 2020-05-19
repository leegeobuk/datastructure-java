package main.datastructures.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> queue1 = new Queue<>();
    private Queue<Integer> queue2 = new Queue<>();
    private Queue<Integer> emptyQueue = new Queue<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 30; i++)
            queue2.enqueue(i);
    }

    @AfterEach
    void clearAll() {
        queue1.clear();
        queue2.clear();
    }

    @Test
    void clear() {
        //given
        queue1.enqueue(5);
        queue1.enqueue(50);

        //when
        queue1.clear();
        queue2.clear();
        emptyQueue.clear();

        //then
        assertTrue(queue1.isEmpty(), "Not empty after clear");
        assertTrue(queue2.isEmpty(), "Not empty after clear");
        assertTrue(emptyQueue.isEmpty(), "Not empty after clear");
    }

    @Test
    void isEmpty() {
        //given
        queue1.enqueue(10);

        //when
        queue1.dequeue();

        //then
        assertTrue(queue1.isEmpty(), "Not empty after dequeueing all elements");
        assertFalse(queue2.isEmpty(), "Non-empty queue is empty");
        assertTrue(emptyQueue.isEmpty(), "False returned for empty queue");
    }

    @Test
    void size() {
        //given
        queue1.enqueue(10);
        queue1.enqueue(11);

        //when
        queue1.dequeue();
        int size1 = queue1.size();
        int size2 = queue2.size();
        int size3 = emptyQueue.size();

        //then
        assertEquals(1, size1, "Wrong size returned after dequeue");
        assertEquals(30, size2, "Wrong size returned after enqueue");
        assertEquals(0, size3, "Wrong size returned for empty queue");
    }

    @Test
    void contains() {
    }

    @Test
    void enqueue() {
    }

    @Test
    void dequeue() {
    }

    @Test
    void peek() {
    }
}