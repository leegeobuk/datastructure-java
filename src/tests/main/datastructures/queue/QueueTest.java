package main.datastructures.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        //given
        queue1.enqueue(5);
        queue1.enqueue(10);
        queue1.enqueue(20);

        //when
        boolean contains1 = queue1.contains(5);
        boolean contains2 = queue1.contains(10);
        boolean contains3 = queue1.contains(20);
        boolean contains4 = queue1.contains(-1);
        boolean contains5 = emptyQueue.contains(10);

        //then
        assertTrue(contains1, "False returned when queue contains the element");
        assertTrue(contains2, "False returned when queue contains the element");
        assertTrue(contains3, "False returned when queue contains the element");
        assertFalse(contains4, "True returned when queue doesn't contain the element");
        assertFalse(contains5, "True returned when queue doesn't contain the element");
        assertThrows(NullPointerException.class, () -> queue1.contains(null),
            "NullPointerException not thrown when null is given for contains");
    }

    @Test
    void enqueue() {
        //given

        //when
        boolean isEnqueued1 = queue1.enqueue(31);
        boolean isEnqueued2 = queue1.enqueue(50);
        boolean isEnqueued3 = queue1.enqueue(87);
        int size = queue1.size();
        Integer first1 = queue1.dequeue();
        Integer first2 = queue1.dequeue();
        Integer first3 = queue1.dequeue();

        //then
        assertTrue(isEnqueued1, "False returned for valid enqueue");
        assertTrue(isEnqueued2, "False returned for valid enqueue");
        assertTrue(isEnqueued3, "False returned for valid enqueue");
        assertEquals(31, first1, "Wrong elements order after enqueue");
        assertEquals(50, first2, "Wrong elements order after enqueue");
        assertEquals(87, first3, "Wrong elements order after enqueue");
        assertEquals(3, size, "Wrong size after enqueue");
        assertThrows(NullPointerException.class, () -> queue1.enqueue(null),
            "NullPointerException not thrown when null is given to enqueue");
    }

    @Test
    void dequeue() {
        //given

        //when
        Integer first1 = queue2.dequeue();
        Integer first2 = queue2.dequeue();
        Integer first3 = queue2.dequeue();
        Integer first4 = queue2.dequeue();
        Integer first5 = queue2.dequeue();
        int size = queue2.size();

        //then
        assertEquals(0, first1, "Wrong element returned after dequeue");
        assertEquals(1, first2, "Wrong element returned after dequeue");
        assertEquals(2, first3, "Wrong element returned after dequeue");
        assertEquals(3, first4, "Wrong element returned after dequeue");
        assertEquals(4, first5, "Wrong element returned after dequeue");
        assertEquals(25, size, "Wrong size returned after dequeue");
        assertThrows(NoSuchElementException.class, () -> emptyQueue.dequeue(),
            "NoSuchElementException not thrown when dequeue on empty list");
    }

    @Test
    void peek() {
    }
}