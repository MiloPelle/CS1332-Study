package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * JUnit 4 tests for ArrayQueue (circular backing array).
 *
 * These check your backing array and front index directly (not just return
 * values), the same way the real homework graders do.
 */
public class ArrayQueueStudentTest {

    private static final int TIMEOUT = 200;

    private ArrayQueue<Object> queue;

    @Before
    public void setUp() {
        queue = new ArrayQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertQueue(arr(9), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testEnqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertQueue(arr(9, 1, 2, 3), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertQueue(arr(9, null, 2, 3), 1);
    }

    @Test(timeout = TIMEOUT)
    public void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        assertEquals(2, queue.peek());
        assertQueue(arr(9, null, 2), 1);
    }

    @Test(timeout = TIMEOUT)
    public void testEnqueueWrapsAround() {
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertQueue(arr(9, null, null, null, 3, 4, 5, 6, 7, 8), 3);
        queue.enqueue(9);
        queue.enqueue(10);
        assertQueue(new Object[] {9, 10, null, 3, 4, 5, 6, 7, 8}, 3);
        assertEquals(3, queue.peek());
    }

    @Test(timeout = TIMEOUT)
    public void testDequeueWrapsFrontBackToZero() {
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 9; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertQueue(arr(9), 0);
    }

    /** Resize must copy in QUEUE order (starting at front) and reset front to 0. */
    @Test(timeout = TIMEOUT)
    public void testResizeWhileWrapped() {
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
        }
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        assertQueue(new Object[] {9, 10, 11, 3, 4, 5, 6, 7, 8}, 3);
        queue.enqueue(12);
        assertQueue(arr(18, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testFrontNotResetWhenEmptied() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        assertQueue(arr(9), 2);
        queue.enqueue(3);
        assertQueue(arr(9, null, null, 3), 2);
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

    @Test(timeout = 1000)
    public void testRandomOperations() {
        LinkedList<Object> ref = new LinkedList<>();
        Random rand = new Random(1332);
        for (int step = 1; step <= 400; step++) {
            String op;
            if (ref.isEmpty() || rand.nextInt(5) < 3) {
                int value = rand.nextInt(100);
                op = "enqueue(" + value + ")";
                queue.enqueue(value);
                ref.addLast(value);
            } else {
                op = "dequeue()";
                assertEquals(op, ref.removeFirst(), queue.dequeue());
            }
            Object[] backing = queue.getBackingArray();
            int front = queue.getFront();
            Object[] expected = new Object[backing.length];
            for (int i = 0; i < ref.size(); i++) {
                expected[(front + i) % backing.length] = ref.get(i);
            }
            assertEquals("size() after step " + step + " " + op, ref.size(), queue.size());
            assertArrayEquals("backing array after step " + step + " " + op + " (front = " + front + ")",
                expected, backing);
        }
    }

    // ------------------------------------------------------------- helpers

    private void assertQueue(Object[] expectedBacking, int expectedFront) {
        int expectedSize = 0;
        for (Object o : expectedBacking) {
            if (o != null) {
                expectedSize++;
            }
        }
        assertEquals("size()", expectedSize, queue.size());
        assertArrayEquals("backing array", expectedBacking, queue.getBackingArray());
        assertEquals("front index", expectedFront, queue.getFront());
    }

    private static Object[] arr(int length, Object... vals) {
        Object[] a = new Object[length];
        System.arraycopy(vals, 0, a, 0, vals.length);
        return a;
    }
}
