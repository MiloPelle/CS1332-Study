package arrays;

import java.util.NoSuchElementException;

/**
 * Your implementation of a backing array-based queue that wraps around
 * (a circular array).
 *
 * front is the index of the first element. The back of the queue is
 * (front + size) % backingArray.length.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests ArrayQueue
 */
public class ArrayQueue<T> {

    /**
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array (in queue order) and reset front to 0.
     *
     * Must be amortized O(1).
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
     * Replace any spots that you dequeue from with null. Do not shrink the
     * array.
     *
     * If the queue becomes empty as a result of this call, do NOT reset
     * front to 0.
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
     * Returns the backing array of the queue.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the front index of the queue.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the front index of the queue
     */
    public int getFront() {
        return front;
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
