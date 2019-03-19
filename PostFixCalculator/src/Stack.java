public class Stack<T> implements StackADT<T>{

    private int noOfElements;
    private T[] stack;

    public Stack(int size)
    {
        stack = (T[]) (new Object[size]);
        noOfElements = 0;
    }
    @Override
    public boolean isEmpty() {
        if (noOfElements >0)
        {
            return false;
        }
        return true;
    }
    @Override
    public int size() {
        return noOfElements;
    }

    @Override
    public void push(T element) {

        if (noOfElements == stack.length)
        {
            throw new IndexOutOfBoundsException("Stack is full can not add more elements");
        }
        stack[noOfElements] = element;
        noOfElements++;

    }

    @Override
    public T peek() {
        if (noOfElements<=0)
        {
            throw new IndexOutOfBoundsException("Can not peek when it is empty");
        }
        return stack[noOfElements -1];
    }

    @Override
    public T pop() {
        if (noOfElements<=0)
        {
            throw new IndexOutOfBoundsException("Can not pop when it is empty");
        }
        T result = stack[noOfElements -1];
        stack[noOfElements -1] = null;
        noOfElements--;
        return result;
    }
}
