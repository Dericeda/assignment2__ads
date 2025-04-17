import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list; // LinkedList to store the queue elements

    public MyQueue() {
        list = new MyLinkedList<>(); // Initialize the LinkedList for the queue
    }

    // Adds an element to the end of the queue
    public void enqueue(T item) {
        list.addLast(item); // Add the item to the end of the queue

    }

    // Removes and returns the first element from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty"); // Throw exception if the queue is empty

        }
        T item = list.getFirst(); // Get the first element from the queue
        list.removeFirst(); // Remove the first element from the queue
        return item; // Return the removed element
    }

    // Returns the first element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty"); // Throw exception if the queue is empty
        }
        return list.getFirst(); // Return the first element without removing it

    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0; // Returns true if the queue is empty
    }

    // Returns the number of elements in the queue
    public int size() {
        return list.size(); // Return the size of the queue
    }
}

