import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    // Adds an element to the end of the list (top of the stack)
    public void push(T item) {
        list.add(item);  // Adding item to the end of the list
    }

    // Removes and returns the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = list.get(list.size() - 1);  // Retrieving the last item (top of the stack)
        list.removeLast();  // Removing the last item (top of the stack)
        return item;
    }

    // Returns the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.get(list.size() - 1);  // Returning the last item without removing it
    }

    // Checks if the stack is empty
    public boolean isEmpty() {

        return list.size() == 0;  // Returns true if the stack is empty
    }

    // Returns the size of the stack
    public int size() {
        return list.size();  // Returns the number of elements in the stack
    }
}
