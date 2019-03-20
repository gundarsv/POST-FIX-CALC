import org.junit.jupiter.api.AfterEach;
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
    public void whenThereIsNoElementsPopThrowsIndexOutOfBoundsException() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
        assertEquals("Can not pop when it is empty", exception.getMessage());
    }
    @Test
    public void whenThereIsNoElementsPeekThrowsIndexOutOfBoundsException() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
        assertEquals("Can not peek when it is empty", exception.getMessage());
    }
    @Test
    public void whenStackIsFullAndThenNewElementIsPushedThrowsIndexOutOfBoundsException() {
        stack.push(3);
        stack.push(4);
        stack.push(2);
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.push(4));
        assertEquals("Stack is full can not add more elements", exception.getMessage());
    }
    @Test
    public void whenStackIsFilledAndThenNewElementIsPushedSizeIsStillThree() {
        stack.push(3);
        stack.push(4);
        stack.push(2);
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> stack.push(4));
        assertEquals("Stack is full can not add more elements", exception.getMessage());
        assertEquals(3,stack.size());
    }

    @Test
    public void calcTestAdd() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("12+");

        assertEquals(3,result);
    }

    @Test
    public void calcTestSubt() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("12-");

        assertEquals(1,result);
    }

    @Test
    public void calcTestSubtNEgative() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("21-");

        assertEquals(-1,result);
    }

    @Test
    public void calcMultiply() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("12*");

        assertEquals(2,result);
    }

    @Test
    public void calcTestDivision() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("43/");

        assertEquals(0.75,result);
    }

    @Test
    public void calcTestModulo() {

        PostFixCalculator calc = new PostFixCalculator();
        double result = calc.CalculatingResult("53%");

        assertEquals(2,result);
    }






}