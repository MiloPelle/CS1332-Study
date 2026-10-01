package practiceexam;

/**
 * Spring 2026 Practice Exam 1 - Question 9: Singly Linked List - Coding [12 points]
 *
 * Implement the moveBackToFront() method, which relocates the last node in
 * the list (the tail) to the front, making it the new head.
 *
 * Requirements:
 *  - Since Node is an inner class, you should access its fields directly
 *    (e.g., node.data).
 *  - Your code should be as efficient as possible.
 *  - You may not assume any other methods in the SinglyLinkedList class are
 *    implemented. You must correctly update both the head and tail pointers.
 */
public class SinglyLinkedList<T> {

    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Moves the last node (tail) to the front of the list.
     *
     * If the list is empty or has only one node, the list remains unchanged.
     * After completion, the last node becomes the new head.
     */
    public void moveBackToFront() {
        Node<T> curr = head;
        if (head == null || size == 1) {return;}
        while (curr.next.next != null) {
            curr = curr;
        }
        tail = curr;
        curr.next = null;
        head = new Node<T>(curr.next.data, head);
    } // END OF METHOD
} // END OF CLASS
