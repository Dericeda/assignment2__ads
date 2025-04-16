import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    // Node class representing each element in the list
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;  // Head of the list (first element)
    private MyNode tail;  // Tail of the list (last element)
    private int size;     // Size of the list

    // Iterator to traverse through the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;  // Returns true if there is a next element
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();  // Throws exception if no more elements
                }
                T data = current.data;
                current = current.next;  // Move to the next element
                return data;
            }
        };
    }

    // Adds an element to the end of the list
    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);  // Create a new node
        if (tail == null) {
            head = tail = newNode;  // If the list is empty, set both head and tail
        } else {
            tail.next = newNode;  // Link the new node to the end
            newNode.prev = tail;  // Set the previous reference to the old tail
            tail = newNode;  // Update the tail to the new node
        }
        size++;
    }

    // Set the value of the node at the given index
    @Override
    public void set(int index, T item) {
        MyNode node = getNodeAt(index);  // Get the node at the specified index
        if (node != null) {
            node.data = item;  // Update the data of the node
        }
    }

    // Adds an element at a specific index in the list
    @Override
    public void add(int index, T item) {
        MyNode newNode = new MyNode(item);  // Create a new node
        if (index == 0) {
            newNode.next = head;  // Insert at the beginning
            if (head != null) head.prev = newNode;  // Set the previous reference for the old head
            head = newNode;  // Update the head to the new node
        } else {
            MyNode node = getNodeAt(index - 1);  // Get the node just before the specified index
            if (node != null) {
                newNode.next = node.next;  // Link the new node to the next node
                if (node.next != null) node.next.prev = newNode;  // Update the previous reference of the next node
                node.next = newNode;  // Link the node to the new node
                newNode.prev = node;  // Set the previous reference to the current node
            }
        }
        size++;
    }

    // Adds an element at the beginning of the list
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);  // Create a new node
        if (head != null) {
            newNode.next = head;  // Link the new node to the old head
            head.prev = newNode;  // Set the previous reference for the old head
        }
        head = newNode;  // Update the head to the new node
        if (tail == null) tail = newNode;  // If the list was empty, update the tail to the new node
        size++;
    }

    // Adds an element at the end of the list (same as add())
    @Override
    public void addLast(T item) {
        add(item);  // Reuse the add method for adding to the end
    }

    // Get the element at the specified index
    @Override
    public T get(int index) {
        MyNode node = getNodeAt(index);  // Get the node at the specified index
        return node != null ? node.data : null;  // Return the data of the node, or null if the index is invalid
    }

    // Get the first element in the list
    @Override
    public T getFirst() {
        return head != null ? head.data : null;  // Return the data of the head, or null if the list is empty
    }

    // Get the last element in the list
    @Override
    public T getLast() {
        return tail != null ? tail.data : null;  // Return the data of the tail, or null if the list is empty
    }

    // Remove the element at the specified index
    @Override
    public void remove(int index) {
        MyNode node = getNodeAt(index);  // Get the node at the specified index
        if (node != null) {
            if (node.prev != null) node.prev.next = node.next;  // Link the previous node to the next node
            if (node.next != null) node.next.prev = node.prev;  // Link the next node to the previous node
            if (node == head) head = node.next;  // Update the head if necessary
            if (node == tail) tail = node.prev;  // Update the tail if necessary
            size--;  // Decrease the size of the list
        }
    }

    // Remove the first element of the list
    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;  // Set the head to the next node
            if (head != null) head.prev = null;  // Set the previous reference of the new head to null
            size--;  // Decrease the size of the list
        }
    }

    // Remove the last element of the list
    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;  // Set the tail to the previous node
            if (tail != null) tail.next = null;  // Set the next reference of the new tail to null
            size--;  // Decrease the size of the list
        }
    }

    // Sort the list (not implemented)
    @Override
    public void sort() {
        // Implement sort if needed
    }

    // Find the index of the first occurrence of an element
    @Override
    public int indexOf(Object object) {
        MyNode node = head;
        for (int i = 0; node != null; i++) {
            if (node.data.equals(object)) return i;  // Return the index if the element is found
            node = node.next;  // Move to the next node
        }
        return -1;  // Return -1 if the element is not found
    }

    // Find the index of the last occurrence of an element
    @Override
    public int lastIndexOf(Object object) {
        MyNode node = tail;
        for (int i = size - 1; node != null; i--) {
            if (node.data.equals(object)) return i;  // Return the index if the element is found
            node = node.prev;  // Move to the previous node
        }
        return -1;  // Return -1 if the element is not found
    }

    // Check if the element exists in the list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;  // Return true if the element is found
    }

    // Convert the list to an array
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];  // Create an array of the correct size
        MyNode node = head;
        for (int i = 0; node != null; i++) {
            array[i] = node.data;  // Copy the data from the node to the array
            node = node.next;  // Move to the next node
        }
        return array;  // Return the array
    }

    // Clear the list
    @Override
    public void clear() {
        head = tail = null;  // Set both head and tail to null
        size = 0;  // Reset the size to 0
    }

    // Return the size of the list
    @Override
    public int size() {
        return size;  // Return the size of the list
    }

    // Helper method to get the node at a specific index
    private MyNode getNodeAt(int index) {
        if (index < 0 || index >= size) return null;  // Return null if the index is out of bounds
        MyNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;  // Move to the node at the specified index
        }
        return node;  // Return the node
    }
}
