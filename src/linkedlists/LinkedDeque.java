package linkedlists;

import java.util.NoSuchElementException;

/**
 * Your implementation of a linked deque. It is a non-circular doubly linked
 * list with head and tail pointers.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests LinkedDeque
 */
public class LinkedDeque<T> {

    // Do not add new instance variables or modify existing ones.
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Node class used by the deque. Already implemented; DO NOT MODIFY.
     */
    public static class Node<T> {
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public Node(T data) {
            this(data, null, null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     * Adds the element to the front of the deque.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addFirst(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Adds the element to the back of the deque.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addLast(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the first element of the deque.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeFirst() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the last element of the deque.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the back of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeLast() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the first data of the deque without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the front of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T getFirst() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the last data of the deque without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the back of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T getLast() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the head node of the deque.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the head of the deque
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the deque.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the tail of the deque
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the deque.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the size of the deque
     */
    public int size() {
        return size;
    }
}
