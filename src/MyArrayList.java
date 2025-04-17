import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data; // Array to hold the list elements
    private int size; // Number of elements in the list
    private static final int INITIAL_CAPACITY = 10; // Initial capacity of the list

    // Constructor that initializes the list with the initial capacity
    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY]; // Initialize the array with initial capacity
        size = 0; // Initially, the list has no elements

    }

    // Adds an element to the end of the list
    @Override
    public void add(T item) {
        ensureCapacity(); // Ensure there is enough capacity for new elements
        data[size++] = item; // Add the item at the end and increment the size
    }

    // Sets the value of the element at the specified index
    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < size) { // Check if the index is valid
            data[index] = item; // Set the item at the specified index
        }
    }

    // Adds an element at the specified index
    @Override
    public void add(int index, T item) {
        if (index >= 0 && index <= size) { // Check if the index is valid
            ensureCapacity(); // Ensure there is enough capacity for new elements
            // Shift the elements to make space for the new item
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = item; // Insert the new item at the specified index
            size++; // Increase the size of the list
        }
    }

    // Adds an element at the beginning of the list (index 0)
    @Override
    public void addFirst(T item) {
        add(0, item); // Reuse the add method to insert at index 0
    }

    // Adds an element at the end of the list (same as add())
    @Override
    public void addLast(T item) {
        add(item); // Reuse the add method to add at the end
    }

    // Gets the element at the specified index
    @Override
    public T get(int index) {
        if (index >= 0 && index < size) { // Check if the index is valid
            return (T) data[index]; // Return the element at the specified index
        }
        return null; // Return null if the index is out of bounds
    }

    // Gets the first element of the list
    @Override
    public T getFirst() {
        if (size > 0) return (T) data[0]; // Return the first element if the list is not empty
        return null; // Return null if the list is empty
    }

    // Gets the last element of the list
    @Override
    public T getLast() {
        if (size > 0) return (T) data[size - 1]; // Return the last element if the list is not empty
        return null; // Return null if the list is empty
    }

    // Removes the element at the specified index
    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) { // Check if the index is valid
            // Shift elements to fill the gap left by the removed item
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--; // Decrease the size of the list
        }
    }

    // Removes the first element of the list
    @Override
    public void removeFirst() {
        remove(0); // Reuse the remove method to remove the first element
    }

    // Removes the last element of the list
    @Override
    public void removeLast() {
        if (size > 0) size--; // Decrease the size of the list if it's not empty
    }

    // Sorts the list (uses Arrays.sort)
    @Override
    public void sort() {
        Arrays.sort((T[]) data, 0, size); // Sort the list using Arrays.sort
    }

    // Finds the index of the first occurrence of the specified object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) { // Loop through the list
            if (data[i].equals(object)) return i; // Return the index if found
        }
        return -1; // Return -1 if the element is not found
    }

    // Finds the index of the last occurrence of the specified object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) { // Loop through the list from the end
            if (data[i].equals(object)) return i; // Return the index if found
        }
        return -1; // Return -1 if the element is not found

    }

    // Checks if the specified object exists in the list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1; // Return true if the element is found
    }

    // Converts the list to an array
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size); // Create a new array and copy the elements to it
    }

    // Clears the list (resets the data and size)
    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY]; // Reset the data array to the initial capacity
        size = 0; // Reset the size to 0

    }

    // Returns the size of the list
    @Override
    public int size() {
        return size; // Return the current size of the list
    }

    // Ensures there is enough capacity to add new elements
    private void ensureCapacity() {
        if (size >= data.length) { // If the list is full
            data = Arrays.copyOf(data, data.length * 2); // Double the capacity of the array
        }
    }

    // Implementation of the iterator() method to iterate over the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size; // Returns true if there are more elements
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(); // Throws exception if no more elements
                }
                return (T) data[currentIndex++]; // Return the current element and move to the next
            }
        };
    }
}
