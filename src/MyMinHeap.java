import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item); // Добавляем элемент в конец
        siftUp(heap.size() - 1); // Перемещаем элемент на нужную позицию
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = heap.get(0); // Минимальный элемент всегда в корне
        T last = heap.get(heap.size() - 1);
        heap.set(0, last); // Помещаем последний элемент на корень
        heap.removeLast(); // Удаляем последний элемент
        siftDown(0); // Восстанавливаем свойства кучи
        return min;
    }

    public T peekMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // Минимальный элемент в корне
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int leftChild;
        int rightChild;
        int smallest;

        while (index < heap.size() / 2) { // Пока у узла есть хотя бы один ребенок
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

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0; // Проверка на пустоту
    }

    public int size() {
        return heap.size(); // Возвращает размер кучи
    }
}
