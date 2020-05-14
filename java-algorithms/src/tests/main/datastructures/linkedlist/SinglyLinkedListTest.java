package main.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        assertEquals(0, linkedList1.size(), "Should be 0 but not when list is empty");
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
        boolean isAppended1 = linkedList1.append(31);
        Integer last1 = linkedList1.getLast();
        boolean isAppended2 = linkedList1.append(50);
        Integer last2 = linkedList1.getLast();
        boolean isAppended3 = linkedList1.append(87);
        Integer last3 = linkedList1.getLast();
        int size = linkedList1.size();

        //then
        assertTrue(isAppended1, "Should be true but not when appended");
        assertTrue(isAppended2, "Should be true but not when appended");
        assertTrue(isAppended3, "Should be true but not when appended");
        assertEquals(31, last1, "Last should be 31 but not when appended");
        assertEquals(50, last2, "Last should be 50 but not when appended");
        assertEquals(87, last3, "Last should be 87 but not when appended");
        assertEquals(3, size, "Should be 3 but not when 3 elements are appended");
        assertThrows(NullPointerException.class, () -> linkedList1.append(null),
            "Should throw NullPointerException but not when null is given to append");
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
        assertTrue(isPrepended1, "Should be true but not when prepended");
        assertTrue(isPrepended2, "Should be true but not when prepended");
        assertTrue(isPrepended3, "Should be true but not when prepended");
        assertEquals(31, first1, "First should be 31 but not when prepended");
        assertEquals(50, first2, "First should be 50 but not when prepended");
        assertEquals(87, first3, "First should be 87 but not when prepended");
        assertEquals(3, size, "Should be 3 but not when 3 elements are prepended");
        assertThrows(NullPointerException.class, () -> linkedList1.prepend(null),
            "Should throw NullPointerException but not when null is given to prepend");
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
        Integer element = linkedList1.get(6);
        int size = linkedList1.size();

        //then
        assertEquals(-1, first, "Wrong first element when inserted to first index");
        assertEquals(10, last, "Wrong last element when inserted to last index");
        assertEquals(100, element, "Element not inserted properly to given index");
        assertEquals(13, size, "Size not counted properly when inserted");
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
        boolean contains5 = linkedList2.contains(10);

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