package main.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void search() {
    }
}