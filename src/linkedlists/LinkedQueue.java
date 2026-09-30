package linkedlists;

import java.util.NoSuchElementException;

/**
 * Your implementation of a linked queue. It should NOT be circular.
 *
 * Enqueue at the tail, dequeue from the head.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests LinkedQueue
 */
public class LinkedQueue<T> {

    // Do not add new instance variables or modify existing ones.
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Node class used by the queue. Already implemented; DO NOT MODIFY.
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     * Adds the data to the back of the queue.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the data from the front of the queue without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T peek() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the head node of the queue.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the head of the queue
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the queue.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the tail of the queue
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
}
