package arrays;

import java.util.NoSuchElementException;

/**
 * Your implementation of a backing array-based stack.
 *
 * The top of the stack is at index size - 1.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests ArrayStack
 */
public class ArrayStack<T> {

    /**
     * The initial capacity of the ArrayStack.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the top of the stack.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length.
     *
     * Must be amortized O(1).
     *
     * @param data the data to add to the top of the stack
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void push(T data) {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Removes and returns the data from the top of the stack.
     *
     * Replace any spots that you pop from with null. Do not shrink the array.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    public T pop() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the data from the top of the stack without removing it.
     *
     * Must be O(1).
     *
     * @return the data at the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    public T peek() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the backing array of the stack.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the backing array of the stack
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the stack.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the size of the stack
     */
    public int size() {
        return size;
    }
}
