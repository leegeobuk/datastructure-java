package main.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> emptyStack = new Stack<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 30; i++)
            stack2.push(i);
    }

    @AfterEach
    void clearAll() {
        stack1.clear();
        stack2.clear();
    }

    @Test
    void size() {
        //given
        stack1.push(3);
        stack1.push(6);
        stack1.push(9);

        //when
        int size1 = stack1.size();
        int size2 = stack2.size();
        int size3 = emptyStack.size();

        //then
        assertEquals(3, size1, "Wrong size returned");
        assertEquals(30, size2, "Wrong size returned");
        assertEquals(0, size3, "Wrong size returned for empty stack");
    }

    @Test
    void empty() {
        //given
        stack1.push(1);
        stack1.pop();

        //when
        boolean empty1 = stack1.empty();
        boolean empty2 = stack2.empty();
        boolean empty3 = emptyStack.empty();

        //then
        assertTrue(empty1, "False returned after popping all elements");
        assertFalse(empty2, "True returned for non-empty stack");
        assertTrue(empty3, "False returned for empty stack");
    }

    @Test
    void clear() {
        //given
        for (int i = 0; i < 10; i++)
            stack1.push(i);

        //when
        stack1.clear();
        stack2.clear();
        emptyStack.clear();

        //then
        assertTrue(stack1.empty(), "Not empty after clear");
        assertTrue(stack2.empty(), "Not empty after clear");
        assertTrue(emptyStack.empty(), "Not empty after clear");
    }

    @Test
    void peek() {
        //given

        //when
        Integer last1 = stack2.peek();
        stack2.pop();
        Integer last2 = stack2.peek();
        stack2.pop();
        Integer last3 = stack2.peek();
        stack2.pop();
        Integer last4 = stack2.peek();
        stack2.pop();
        Integer last5 = stack2.peek();

        //then
        assertEquals(29, last1, "Wrong element at the top of stack");
        assertEquals(28, last2, "Wrong element at the top of stack");
        assertEquals(27, last3, "Wrong element at the top of stack");
        assertEquals(26, last4, "Wrong element at the top of stack");
        assertEquals(25, last5, "Wrong element at the top of stack");
        assertThrows(NoSuchElementException.class, () -> emptyStack.peek(),
            "NoSuchElementException not thrown for peek on empty stack");
    }

    @Test
    void push() {
        //given

        //when
        Integer pushed1 = stack1.push(3);
        Integer last1 = stack1.peek();
        Integer pushed2 = stack1.push(6);
        Integer last2 = stack1.peek();
        Integer pushed3 = stack1.push(9);
        Integer last3 = stack1.peek();
        Integer pushed4 = stack1.push(12);
        Integer last4 = stack1.peek();
        int size = stack1.size();

        //then
        assertEquals(3, pushed1, "Wrong element pushed");
        assertEquals(6, pushed2, "Wrong element pushed");
        assertEquals(9, pushed3, "Wrong element pushed");
        assertEquals(12, pushed4, "Wrong element pushed");
        assertEquals(3, last1, "Wrong element on top after push");
        assertEquals(6, last2, "Wrong element on top after push");
        assertEquals(9, last3, "Wrong element on top after push");
        assertEquals(12, last4, "Wrong element on top after push");
        assertEquals(4, size, "Wrong size returned after push");
        assertThrows(NullPointerException.class, () -> stack1.push(null),
            "NullPointerException not thrown when null pushed");
    }

    @Test
    void pop() {
        //given


        //when


        //then

    }

    @Test
    void search() {
    }
}