import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item); // Добавление элемента в конец списка
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = list.get(list.size() - 1); // Извлечение последнего элемента
        list.removeLast(); // Удаление последнего элемента
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.get(list.size() - 1); // Возвращает последний элемент, не удаляя
    }

    public boolean isEmpty() {
        return list.size() == 0; // Проверка на пустоту
    }

    public int size() {
        return list.size(); // Возвращает размер стека
    }
}