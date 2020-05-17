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
        //given

        //when
        boolean isAppended1 = linkedList1.append(31);
        Integer last1 = linkedList1.getLast();
        boolean isAppended2 = linkedList1.append(50);
        Integer last2 = linkedList1.getLast();
        boolean isAppended3 = linkedList1.append(87);
        Integer last3 = linkedList1.getLast();
        int size = linkedList1.size();

        //then
        assertTrue(isAppended1, "False returned for proper append");
        assertTrue(isAppended2, "False returned for proper append");
        assertTrue(isAppended3, "False returned for proper append");
        assertEquals(31, last1, "Wrong last element after append");
        assertEquals(50, last2, "Wrong last element after append");
        assertEquals(87, last3, "Wrong last element after append");
        assertEquals(3, size, "Wrong size after append");
        assertThrows(NullPointerException.class, () -> linkedList1.append(null),
            "NullPointerException not thrown when null is given to append");
    }

    @Test
    void prepend() {
        //given

        //when
        boolean isPrepended1 = linkedList1.prepend(31);
        Integer first1 = linkedList1.getFirst();
        boolean isPrepended2 = linkedList1.prepend(50);
        Integer first2 = linkedList1.getFirst();
        boolean isPrepended3 = linkedList1.prepend(87);
        Integer first3 = linkedList1.getFirst();
        int size = linkedList1.size();

        //then
        assertTrue(isPrepended1, "False returned for proper prepend");
        assertTrue(isPrepended2, "False returned for proper prepend");
        assertTrue(isPrepended3, "False returned for proper prepend");
        assertEquals(31, first1, "Wrong first element return after prepend");
        assertEquals(50, first2, "Wrong first element return after prepend");
        assertEquals(87, first3, "Wrong first element return after prepend");
        assertEquals(3, size, "Wrong size returned after prepend");
        assertThrows(NullPointerException.class, () -> linkedList1.prepend(null),
            "NullPointerException not thrown when null is given to prepend");
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