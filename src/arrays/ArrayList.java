package arrays;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests ArrayList
 */
public class ArrayList<T> {

    /**
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     *
     * Java does not allow for regular generic array creation, so you have to
     * cast an Object[] to a T[] to get the generic typing.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the specified index.
     *
     * Remember that this add may require elements to be shifted.
     *
     * If the backing array is full, regrow it to double its current length
     * before adding.
     *
     * Must be amortized O(1) for index size and O(n) for all other cases.
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
     * Remember that this add may require elements to be shifted.
     *
     * Must be O(n).
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
     * Must be amortized O(1).
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
     * Remember that this remove may require elements to be shifted. The spot
     * that is no longer used must be set to null. Do not shrink the array.
     *
     * Must be O(1) for index size - 1 and O(n) for all other cases.
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
     * Remember that this remove may require elements to be shifted.
     *
     * Must be O(n).
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
     * Must be O(1).
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
     * Must be O(1).
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
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        // WRITE YOUR CODE HERE. Delete the line below when you start.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        return backingArray;
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
