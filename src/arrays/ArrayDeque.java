package arrays;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayDeque that wraps around at both ends
 * (a circular array).
 *
 * front is the index of the first element. The last element is at
 * (front + size - 1) mod backingArray.length.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests ArrayDeque
 */
public class ArrayDeque<T> {

    /**
     * The initial capacity of the ArrayDeque.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * Constructs a new ArrayDeque.
     */
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the element to the front of the deque.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array (in deque order) and reset front to 0, THEN
     * add the new element as usual. (So after a resize, the new front element
     * ends up at the last index of the new array.)
     *
     * Must be amortized O(1).
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
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array (in deque order) and reset front to 0, THEN
     * add the new element as usual.
     *
     * Must be amortized O(1).
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
     * Do not shrink the backing array. Replace any spots that you remove
     * from with null. If the deque becomes empty as a result of this call,
     * do NOT reset front to 0.
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
     * Do not shrink the backing array. Replace any spots that you remove
     * from with null. If the deque becomes empty as a result of this call,
     * do NOT reset front to 0.
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
     * Returns the smallest non-negative remainder when dividing index by
     * modulo. So, for example, if modulo is 5, then this method returns
     * either 0, 1, 2, 3, or 4, depending on what index is.
     *
     * Careful: in Java, -1 % 5 is -1, not 4!
     *
     * You may assume that index > -modulo, which is the case here since
     * front is always in [0, backingArray.length).
     *
     * @param index  the number to take the remainder of
     * @param modulo the divisor (in this case, the capacity of the deque)
     * @return the wrapped index
     */
    private static int mod(int index, int modulo) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the backing array of the deque.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the backing array of the deque
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the front index of the deque.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the front index of the deque
     */
    public int getFront() {
        return front;
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
