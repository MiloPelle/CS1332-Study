package linkedlists;

import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularSinglyLinkedList WITHOUT a tail pointer.
 *
 * The last node's next pointer points back to the head. With one node, the
 * head points to itself. With no nodes, head is null.
 *
 * There is no tail pointer, so hitting the O(1) requirements for addToFront,
 * addToBack, and removeFromFront takes some cleverness.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests CircularSinglyLinkedList
 */
public class CircularSinglyLinkedList<T> {

    // Do not add new instance variables or modify existing ones.
    private Node<T> head;
    private int size;

    /**
     * Node class used by the list. Already implemented; DO NOT MODIFY.
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
     * Adds the data to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index at which to add the new data
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Adds the data to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Adds the data to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the data at the specified index.
     *
     * Must be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Must be O(n).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the data at the specified index.
     *
     * Must be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Clears the list.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the last copy of the given data from the list.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the list instead. Compare with equals(), not ==.
     *
     * Must be O(n).
     *
     * @param data the data to be removed from the list
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if data is not found
     */
    public T removeLastOccurrence(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns an array representation of the linked list.
     *
     * Must be O(n) for all cases.
     *
     * @return an array of length size holding all of the objects in the
     *         list in the same order
     */
    public Object[] toArray() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the head of the list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }
}
