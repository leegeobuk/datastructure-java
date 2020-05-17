package main.datastructures.linkedlist.doubly;

import main.datastructures.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        //given
        linkedList1.append(0);
        linkedList1.append(1);
        linkedList1.append(1);
        linkedList1.append(0);
        linkedList1.append(4);

        //when
        int index1 = linkedList1.lastIndexOf(4);
        int index2 = linkedList1.lastIndexOf(0);
        int index3 = linkedList1.lastIndexOf(1);
        int index4 = linkedList1.lastIndexOf(10);
        int index5 = emptyList.lastIndexOf(10);

        //then
        assertEquals(4, index1, "Wrong index returned");
        assertEquals(3, index2, "Wrong last occurrence index returned");
        assertEquals(2, index3, "Wrong last occurrence index returned");
        assertEquals(-1, index4, "Positive index returned when element doesn't exist");
        assertEquals(-1, index5, "Positive index returned when element doesn't exist");
        assertThrows(NullPointerException.class, () -> linkedList1.indexOf(null),
            "NullPointerException not thrown when null is given to find its last index");
    }

    @Test
    void get() {
        //given
        for (int i = 0; i < 10; i++)
            linkedList1.append(i);

        //when
        Integer first = linkedList1.get(0);
        Integer last = linkedList1.get(linkedList1.size() - 1);
        Integer sixth = linkedList1.get(5);
        Integer seventh = linkedList1.get(6);

        //then
        assertEquals(0, first, "Wrong element returned when get() called");
        assertEquals(9, last, "Wrong element returned when get() called");
        assertEquals(5, sixth, "Wrong element returned when get() called");
        assertEquals(6, seventh, "Wrong element returned when get() called");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.get(-1),
            "IndexOutOfBoundsException not thrown when index is negative");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList1.get(10),
            "IndexOutOfBoundsException not thrown when index is greater than last index");
    }

    @Test
    void getFirst() {
        //given
        for (int i = 0; i < 10; i++)
            linkedList1.append(i);

        //when
        Integer first = linkedList1.getFirst();
        linkedList1.removeFirst();
        Integer second = linkedList1.getFirst();

        //then
        assertEquals(0, first, "Wrong first element returned");
        assertEquals(1, second, "Wrong first element returned");
        assertThrows(NoSuchElementException.class, () -> emptyList.getFirst(),
            "NoSuchElementException not thrown when querying first element of empty list");
    }

    @Test
    void getLast() {
        //given
        for (int i = 0; i < 10; i++)
            linkedList1.append(i);

        //when
        Integer last = linkedList1.getLast();
        linkedList1.removeLast();
        Integer secondToLast = linkedList1.getLast();

        //then
        assertEquals(9, last, "Wrong last element returned");
        assertEquals(8, secondToLast, "Wrong last element returned");
        assertThrows(NoSuchElementException.class, () -> emptyList.getLast(),
            "NoSuchElementException not thrown when querying last element of empty list");
    }

    @Test
    void removeAt() {
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        for (int i = 0; i < 30; i++)
            linkedList.append("" + i);

        //when
        String removed1 = linkedList.removeAt(0);
        String removed2 = linkedList.removeAt(linkedList.size() - 1);
        String removed3 = linkedList.removeAt(10);
        String removed4 = linkedList.removeAt(20);
        int size = linkedList.size();

        //then
        assertEquals("0", removed1, "Wrong element removed");
        assertEquals("29", removed2, "Wrong element removed");
        assertEquals("11", removed3, "Wrong element removed");
        assertEquals("22", removed4, "Wrong element removed");
        assertEquals(26, size, "Wrong size returned when removed by index");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.removeAt(-1),
            "IndexOutOfBoundsException not thrown when negative index given");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.removeAt(linkedList.size()),
            "IndexOutOfBoundsException not thrown when index is greater than last index");
    }

    @Test
    void remove() {
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        for (int i = 0; i < 20; i++)
            linkedList.append("" + (i % 10));
        linkedList.append("20");

        //when
        boolean removed1 = linkedList.remove("1");
        boolean removed2 = linkedList.remove("0");
        boolean removed3 = linkedList.remove("20");
        boolean removed4 = linkedList.remove("0");
        boolean removed5 = linkedList.remove("10");
        linkedList.clear();

        //then
        assertTrue(removed1, "False returned when 2nd element removed");
        assertTrue(removed2, "False returned when 1st element removed");
        assertTrue(removed3, "False returned when last element removed");
        assertTrue(removed4, "False returned when element removed");
        assertFalse(removed5, "True returned when removing non-existing element");
        assertThrows(NullPointerException.class, () -> linkedList.remove(null),
            "NullPointerException not thrown when null given to remove");
        assertThrows(NoSuchElementException.class, () -> linkedList.remove("10"),
            "NoSuchElementException not thrown when removing element of an empty list");
    }

    @Test
    void removeFirst() {
        //given

        //when
        Integer first1 = linkedList2.removeFirst();
        Integer first2 = linkedList2.removeFirst();
        Integer first3 = linkedList2.removeFirst();
        Integer first4 = linkedList2.removeFirst();
        Integer first5 = linkedList2.removeFirst();
        int size = linkedList2.size();

        //then
        assertEquals(0, first1, "Wrong element returned after removeFirst");
        assertEquals(1, first2, "Wrong element returned after removeFirst");
        assertEquals(2, first3, "Wrong element returned after removeFirst");
        assertEquals(3, first4, "Wrong element returned after removeFirst");
        assertEquals(4, first5, "Wrong element returned after removeFirst");
        assertEquals(25, size, "Wrong size returned after removeFirst");
        assertThrows(NoSuchElementException.class, () -> emptyList.removeFirst(),
            "NoSuchElementException not thrown when removeFirst on empty list");
    }

    @Test
    void removeLast() {
    }
}