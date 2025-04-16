import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < size) {
            data[index] = item;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index >= 0 && index <= size) {
            ensureCapacity();
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = item;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) data[index];
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (size > 0) return (T) data[0];
        return null;
    }

    @Override
    public T getLast() {
        if (size > 0) return (T) data[size - 1];
        return null;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size > 0) size--;
    }

    @Override
    public void sort() {
        Arrays.sort((T[]) data, 0, size);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    // Реализация метода iterator()
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[currentIndex++];
            }
        };
    }
}
