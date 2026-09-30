package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * JUnit 4 tests for LinkedQueue.
 *
 * These walk your nodes directly (not just return values), the same way the
 * real homework graders do.
 */
public class LinkedQueueStudentTest {

    private static final int TIMEOUT = 200;

    private LinkedQueue<Object> queue;

    @Before
    public void setUp() {
        queue = new LinkedQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertQueue();
    }

    @Test(timeout = TIMEOUT)
    public void testEnqueue() {
        queue.enqueue(1);
        assertQueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertQueue(1, 2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertQueue(2, 3);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertQueue();
    }

    /** Catches a tail pointer that isn't cleaned up when the queue empties. */
    @Test(timeout = TIMEOUT)
    public void testReuseAfterEmptied() {
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        assertQueue(2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertQueue(1, 2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testEnqueueNull() {
        queue.enqueue(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testDequeueEmpty() {
        queue.dequeue();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        queue.peek();
    }

    // ------------------------------------------------------------- helpers

    /** Walks from head and checks the data, the end of the chain, tail, and size. */
    private void assertQueue(Object... frontToBack) {
        LinkedQueue.Node<Object> cur = queue.getHead();
        LinkedQueue.Node<Object> last = null;
        for (int i = 0; i < frontToBack.length; i++) {
            assertNotNull("queue ended after " + i + " nodes, expected " + frontToBack.length, cur);
            assertEquals("data at index " + i, frontToBack[i], cur.getData());
            last = cur;
            cur = cur.getNext();
        }
        assertNull("node after the back should be null (extra nodes, or a cycle)", cur);
        if (last != queue.getTail()) {
            fail("tail should be " + describe(last) + " but is " + describe(queue.getTail()));
        }
        assertEquals("size()", frontToBack.length, queue.size());
    }

    private static String describe(LinkedQueue.Node<Object> node) {
        return node == null ? "null" : "the node holding " + node.getData();
    }
}
