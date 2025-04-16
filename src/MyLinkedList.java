import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {

        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }


    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNodeAt(index);
        if (node != null) {
            node.data = item;
        }
    }

    @Override
    public void add(int index, T item) {
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
        } else {
            MyNode node = getNodeAt(index - 1);
            if (node != null) {
                newNode.next = node.next;
                if (node.next != null) node.next.prev = newNode;
                node.next = newNode;
                newNode.prev = node;
            }
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) tail = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        MyNode node = getNodeAt(index);
        return node != null ? node.data : null;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNodeAt(index);
        if (node != null) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            if (node == head) head = node.next;
            if (node == tail) tail = node.prev;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            size--;
        }
    }

    @Override
    public void sort() {
        // Implement sort if needed.
    }

    @Override
    public int indexOf(Object object) {
        MyNode node = head;
        for (int i = 0; node != null; i++) {
            if (node.data.equals(object)) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode node = tail;
        for (int i = size - 1; node != null; i--) {
            if (node.data.equals(object)) return i;
            node = node.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode node = head;
        for (int i = 0; node != null; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNodeAt(int index) {
        if (index < 0 || index >= size) return null;
        MyNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
