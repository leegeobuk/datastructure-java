package main.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>();
    SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
    SinglyLinkedList<Integer> linkedList3 = new SinglyLinkedList<>();
    static SinglyLinkedList<Integer> bulkList;

    @BeforeAll
    static void setUp() {
         bulkList = new SinglyLinkedList<>();
        for (int i = 0; i < 30; i++) {
            bulkList.append(i);
        }
    }

    @BeforeEach
    void init() {
        linkedList1.clear();
        linkedList2.clear();
        linkedList3.clear();
    }

    @Test
    void isEmpty() {
        //given
        linkedList2.append(1);
        linkedList3.append(1);
        linkedList3.append(2);

        //when
        linkedList2.removeFirst();
        linkedList3.removeFirst();

        //then
        assertTrue(linkedList1.isEmpty(), "Should be empty but not when began from empty list");
        assertTrue(linkedList2.isEmpty(), "Should be empty but not after removeFirst");
        assertFalse(linkedList3.isEmpty(), "Should not be empty but empty after removeFirst");
    }

    @Test
    void size() {
        //given
        linkedList2.append(1);
        linkedList3.append(1);
        linkedList3.append(2);

        //when
        linkedList2.removeFirst();
        linkedList3.removeFirst();

        //then
        assertEquals(0, linkedList1.size(), "Should be 0 but not when began as empty list");
        assertEquals(0, linkedList2.size(), "Should be 0 but not after removeFirst");
        assertEquals(1, linkedList3.size(), "Should be 1 but not after removeFirst");
    }

    @Test
    void clear() {
        //given
        linkedList2.append(1);
        linkedList3.append(1);
        linkedList3.append(2);

        //when
        linkedList1.clear();
        linkedList2.clear();
        linkedList3.clear();


        //then
        assertTrue(linkedList1.isEmpty(), "Should be empty but not after cleared");
        assertTrue(linkedList2.isEmpty(), "Should be empty but not after cleared");
        assertTrue(linkedList3.isEmpty(), "Should be empty but not after cleared");
    }

    @Test
    void append() {
        //given


        //when


        //then

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
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void testToString() {
    }
}