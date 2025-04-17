public class Main {
    public static void main(String[] args) {
        // Create a queue
        MyQueue<Integer> queue = new MyQueue<>();

        // Add elements to the queue
        queue.enqueue(10);  // Add 10 to the queue
        queue.enqueue(20);  // Add 20 to the queue
        queue.enqueue(30);  // Add 30 to the queue

        // Display the current size of the queue
        System.out.println("Queue size: " + queue.size());  // Expected: 3

        // Check the first element in the queue without removing it
        System.out.println("First element in the queue: " + queue.peek());  // Expected: 10

        // Dequeue an element
        System.out.println("Dequeuing element: " + queue.dequeue());  // Expected: 10

        // After dequeue, the queue size should be 2
        System.out.println("Queue size after dequeue: " + queue.size());  // Expected: 2

        // Dequeue another element
        System.out.println("Dequeuing element: " + queue.dequeue());  // Expected: 20

        // Check the queue after the second dequeue
        System.out.println("First element in the queue after second dequeue: " + queue.peek());  // Expected: 30

        // Dequeue the last element
        System.out.println("Dequeuing element: " + queue.dequeue());  // Expected: 30

        // Check if the queue is now empty
        System.out.println("Is the queue empty? " + queue.isEmpty());  // Expected: true



    }
}
