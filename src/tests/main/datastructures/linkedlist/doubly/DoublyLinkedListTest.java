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
        //given
        for (int i = 0; i < 10; i++)
            linkedList1.append(i);

        //when
        linkedList1.insert(0, -1);
        Integer first = linkedList1.getFirst();
        linkedList1.insert(linkedList1.size(), 10);
        Integer last = linkedList1.getLast();
        linkedList1.insert(6, 100);
        Integer seventh = linkedList1.get(6);
        int size = linkedList1.size();

        //then
        assertEquals(-1, first, "Wrong first element when inserted to first index");
        assertEquals(10, last, "Wrong last element when inserted to last index");
        assertEquals(100, seventh, "Element not inserted to given index");
        assertEquals(13, size, "Wrong size returned after insert");
        assertThrows(NullPointerException.class, () -> linkedList1.insert(0, null),
            "NullPointerException not thrown when null is inserted");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.insert(-1, 10),
            "IndexOutOfBoundsException not thrown when negative index is given");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.insert(size + 1, 10),
            "IndexOutOfBoundsException not thrown when index is greater than size");
    }

    @Test
    void set() {
        //given
        for (int i = 0; i < 10; i++)
            linkedList1.append(i);

        //when
        Integer prevFirst = linkedList1.set(0, -10);
        Integer first = linkedList1.getFirst();
        Integer prevLast = linkedList1.set(linkedList1.size() - 1, 100);
        Integer last = linkedList1.getLast();
        Integer prevSixth = linkedList1.set(5, 500);
        Integer sixth = linkedList1.get(5);
        int size = linkedList1.size();

        //then
        assertEquals(0, prevFirst, "Wrong previous element when set to new element");
        assertEquals(9, prevLast, "Wrong previous element when set to new element");
        assertEquals(5, prevSixth, "Wrong previous element when set to new element");
        assertEquals(-10, first, "Wrong element when set");
        assertEquals(100, last, "Wrong element when set");
        assertEquals(500, sixth, "Wrong element when set");
        assertThrows(NullPointerException.class, () -> linkedList1.set(0, null),
            "NullPointerException not thrown when null is given to set");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.set(-1, 10),
            "IndexOutOfBoundsException not thrown when index less than 0 is given");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.set(size, 10),
            "IndexOutOfBoundsException not thrown when index is greater than last index");
    }

    @Test
    void contains() {
        //given
        linkedList1.append(5);
        linkedList1.append(10);
        linkedList1.append(20);

        //when
        boolean contains1 = linkedList1.contains(5);
        boolean contains2 = linkedList1.contains(10);
        boolean contains3 = linkedList1.contains(20);
        boolean contains4 = linkedList1.contains(-1);
        boolean contains5 = emptyList.contains(10);

        //then
        assertTrue(contains1, "False returned when list contains the element");
        assertTrue(contains2, "False returned when list contains the element");
        assertTrue(contains3, "False returned when list contains the element");
        assertFalse(contains4, "True returned when list doesn't contain the element");
        assertFalse(contains5, "True returned when list doesn't contain the element");
        assertThrows(NullPointerException.class, () -> linkedList1.contains(null),
            "NullPointerException not thrown when null is given to check if it exists");
    }

    @Test
    void indexOf() {
        //given
        linkedList1.append(0);
        linkedList1.append(1);
        linkedList1.append(1);
        linkedList1.append(0);
        linkedList1.append(4);

        //when
        int index1 = linkedList1.indexOf(4);
        int index2 = linkedList1.indexOf(0);
        int index3 = linkedList1.indexOf(1);
        int index4 = linkedList1.indexOf(10);
        int index5 = emptyList.indexOf(10);

        //then
        assertEquals(4, index1, "Wrong index returned");
        assertEquals(0, index2, "Wrong first occurrence index returned");
        assertEquals(1, index3, "Wrong first occurrence index returned");
        assertEquals(-1, index4, "Positive index returned when element doesn't exist");
        assertEquals(-1, index5, "Positive index returned when element doesn't exist");
        assertThrows(NullPointerException.class, () -> linkedList1.indexOf(null),
            "NullPointerException not thrown when null is given to find its index");
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