import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyQueue<T> {
        private MyLinkedList<T> list;

        public MyQueue() {
            list = new MyLinkedList<>();
        }

        public void enqueue(T item) {
            list.addLast(item); // Добавление элемента в конец очереди
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            T item = list.getFirst(); // Извлечение первого элемента
            list.removeFirst(); // Удаление первого элемента
            return item;
        }

        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return list.getFirst(); // Возвращает первый элемент без удаления
        }

        public boolean isEmpty() {
            return list.size() == 0; // Проверка на пустоту
        }

        public int size() {
            return list.size(); // Возвращает размер очереди
        }
    }


