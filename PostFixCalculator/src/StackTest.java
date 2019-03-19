import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;
    @BeforeEach
    void setUp() {
        stack = new Stack(3);
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }
    //Zero
    @Test
    void whenCreatedStackIsEmpty()
    {
        assertEquals(true,stack.isEmpty());
    }
    @Test
    void whenCreatedSizeIsZero()
    {
        assertEquals(0,stack.size());
    }
    //One
    @Test
    void possibleToAddElement()
    {
        stack.push(4);
    }
    @Test
    void whenOneElementIsAddedSizeIsOne()
    {
        stack.push(4);
        assertEquals(1,stack.size());
    }
    @Test
    void whenOneElementIsAddedPeekCanReturnElement()
    {
        stack.push(4);
        assertEquals(4,stack.peek());
    }
    @Test
    void whenOneElementIsAddedStackIsNotEmpty()
    {
        stack.push(4);
        assertEquals(false,stack.isEmpty());
    }
    @Test
    void whenOneElementIsAddedPopCanReturnTheRemovedElement()
    {
        stack.push(4);
        assertEquals(4,stack.pop());
    }
    @Test
    void whenOneElementIsAddedThenRemovedSizeIsZero()
    {
        stack.push(4);
        stack.pop();
        assertEquals(0,stack.size());
    }
    //More
    @Test
    void whenTwoElementsIsAddedTheyCanBeRemovedUsingPop()
    {
        stack.push(4);
        stack.push(2);
        assertEquals(2,stack.pop());
        assertEquals(4,stack.pop());
    }
    @Test
    void whenTwoElementsIsAddedSizeIsTwo()
    {
        stack.push(4);
        stack.push(2);
        assertEquals(2,stack.size());
    }
    @Test
    void whenTwoElementsIsAddedAndTwoElementsIsRemovedSizeIsZero()
    {
        stack.push(4);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(0,stack.size());
    }
    @Test
    void whenTwoElementsIsAddedAndTwoElementsIsRemovedIsEmptyReturnsTrue()
    {
        stack.push(4);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(true,stack.isEmpty());
    }
    //Boundaries
    @Test
    void whenStackIsFilledThenOneElementIsRemovedAndOneElementIsAdded()
    {
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.pop();
        stack.push(5);
    }
    @Test
    void whenStackIsFilledSizeMustBeThree()
    {
        stack.push(3);
        stack.push(4);
        stack.push(2);
        assertEquals(3,stack.size());
    }
    //Exceptions
    @Test
    public void testFooThrowsIndexOutOfBoundsException() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
        assertEquals("Can not pop when it is empty", exception.getMessage());
    }






}