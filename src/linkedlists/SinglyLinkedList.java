package linkedlists;

import java.util.NoSuchElementException;

/**
 * Your implementation of a non-circular SinglyLinkedList with a tail pointer.
 *
 * Fill in every method that throws "TODO", then run:
 *     java -cp bin Tests SinglyLinkedList
 */
public class SinglyLinkedList<T> {

    // Do not add new instance variables or modify existing ones.
    private Node<T> head;
    private Node<T> tail;
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
     * Adds the element to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index to add the new element
     * @param data  the data to add
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (data == null) {
            throw new IllegalArgumentException();
        }
        if (index == 0 || size == 0) {
            addToFront(data);
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.setNext(new Node<T>(data, curr.getNext()));
            if (index == size) {
                tail = tail.getNext();
            }
            size++;
        }    
    }
    

    /**
     * Adds the element to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        head = new Node<T>(data, head);
        size++;
        if (size == 1) {
            tail = head;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            addToFront(data);
        } else {
            tail.setNext(new Node<T>(data));
            tail = tail.getNext();
            size++;
        }
    }

    /**
     * Removes and returns the element at the specified index.
     *
     * Must be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the element to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1 || index == 0) {
            T temp = removeFromFront();
            return temp;
        }
        Node<T> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        if (curr.getNext() == tail) {
            tail = curr;
        }
        T temp = curr.getNext().getData();
        curr.setNext(curr.getNext().getNext());
        size--;
        return temp;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T temp = head.getData();
        if (tail == head) {
            tail = null;
        }
        head = head.getNext();
        size--;
        return temp;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * Must be O(n).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        T temp = null;
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            temp = removeFromFront();
        } else {
            Node<T> curr = head;
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            temp = curr.getNext().getData();
            curr.setNext(null);
            tail = curr;
            size--;
        }
        return temp;

    }

    /**
     * Returns the element at the specified index.
     *
     * Must be O(1) for indices 0 and size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr =  curr.getNext();
        }
        return curr.getData();
    }

    /**
     * Returns whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        head = null;
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
     * Returns the tail node of the list.
     *
     * For grading purposes only. DO NOT MODIFY THIS METHOD!
     *
     * @return the node at the tail of the list
     */
    public Node<T> getTail() {
        return tail;
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
