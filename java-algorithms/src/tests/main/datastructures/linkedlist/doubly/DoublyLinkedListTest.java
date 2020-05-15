package main.datastructures.linkedlist.doubly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList<Integer> linkedList1 = new DoublyLinkedList<>();
    DoublyLinkedList<Integer> linkedList2 = new DoublyLinkedList<>();
    DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 30; i++)
            linkedList2.append(i);
    }

    @AfterEach
    void clearAll() {
        linkedList1.clear();
        linkedList2.clear();
    }

    @Test
    void isEmpty() {
        //given
        linkedList1.append(1);

        //when
        linkedList1.removeFirst();

        //then
        assertTrue(linkedList1.isEmpty(), "Should be empty but not when removed");
        assertFalse(linkedList2.isEmpty(), "Should not be empty but empty");
        assertTrue(emptyList.isEmpty(), "Should be empty but not when empty list");
    }

    @Test
    void size() {
        //given
        linkedList1.append(1);

        //when
        linkedList1.removeFirst();

        //then
        assertEquals(0, linkedList1.size(), "Wrong size returned when removed");
        assertEquals(30, linkedList2.size(), "Wrong size returned");
        assertEquals(0, emptyList.size(), "Wrong size returned for empty list");
    }

    @Test
    void clear() {
        //given
        linkedList1.append(1);

        //when
        linkedList1.clear();
        linkedList2.clear();
        emptyList.clear();

        //then
        assertTrue(linkedList1.isEmpty(), "Should be empty but not after cleared");
        assertTrue(linkedList2.isEmpty(), "Should be empty but not after cleared");
        assertTrue(emptyList.isEmpty(), "Should be empty but not after cleared");
    }

    @Test
    void append() {
    }

    @Test
    void prepend() {
    }

    @Test
    void insert() {
    }

    @Test
    void set() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void removeAt() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }
}