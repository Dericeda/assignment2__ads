import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Insert an element into the heap
    public void insert(T item) {
        heap.add(item); // Add the element to the end
        siftUp(heap.size() - 1); // Move the element to its correct position
    }

    // Extract the minimum element from the heap
    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = heap.get(0); // The minimum element is always at the root
        T last = heap.get(heap.size() - 1);
        heap.set(0, last); // Place the last element at the root
        heap.removeLast(); // Remove the last element
        siftDown(0); // Restore the heap property
        return min;
    }

    // Peek at the minimum element without removing it
    public T peekMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // The minimum element is at the root
    }

    // Move the element at the given index up to its correct position in the heap
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;
            }
            swap(index, parent); // Swap the element with its parent
            index = parent;
        }
    }

    // Move the element at the given index down to restore the heap property
    private void siftDown(int index) {
        int leftChild;
        int rightChild;
        int smallest;

        while (index < heap.size() / 2) { // While the node has at least one child
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest); // Swap the current node with the smallest child
            index = smallest;
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0; // Check if the heap has no elements
    }

    // Get the number of elements in the heap
    public int size() {
        return heap.size(); // Return the size of the heap
    }
}
