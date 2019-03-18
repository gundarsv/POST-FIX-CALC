public interface StackADT<T> {
    boolean isEmpty();
    int size();
    void push(T element);
    T peek();
    T pop();
}
