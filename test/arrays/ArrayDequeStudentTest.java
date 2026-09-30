package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * JUnit 4 tests for ArrayDeque (circular backing array).
 *
 * These check your backing array and front index directly (not just return
 * values), the same way the real homework graders do.
 */
public class ArrayDequeStudentTest {

    private static final int TIMEOUT = 200;

    private ArrayDeque<Object> deque;

    @Before
    public void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertDeque(arr(9), 0);
    }

    @Test(timeout = TIMEOUT)
    public void testAddLast() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertDeque(arr(9, 1, 2, 3), 0);
    }

    /** From front 0, addFirst must wrap front to the LAST index (8), not -1. */
    @Test(timeout = TIMEOUT)
    public void testAddFirstWrapsToEnd() {
        deque.addFirst(1);
        assertDeque(arr(9, null, null, null, null, null, null, null, null, 1), 8);
        deque.addFirst(2);
        assertDeque(arr(9, null, null, null, null, null, null, null, 2, 1), 7);
    }

    @Test(timeout = TIMEOUT)
    public void testAddFirstAndLastMixed() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        assertDeque(new Object[] {3, null, null, null, null, null, null, 2, 1}, 7);
        assertEquals(2, deque.getFirst());
        assertEquals(3, deque.getLast());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFirstAndLastAcrossWrap() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        assertEquals(2, deque.removeFirst());
        assertDeque(new Object[] {3, null, null, null, null, null, null, null, 1}, 8);
        assertEquals(3, deque.removeLast());
        assertDeque(arr(9, null, null, null, null, null, null, null, null, 1), 8);
        assertEquals(1, deque.removeFirst());   // front wraps from 8 to 0
        assertDeque(arr(9), 0);
    }

    /** Resize copies in deque order to index 0, resets front to 0, THEN adds. */
    @Test(timeout = TIMEOUT)
    public void testAddLastResizeWhileWrapped() {
        fillWrapped();
        deque.addLast(10);
        assertDeque(arr(18, 3, 2, 1, 4, 5, 6, 7, 8, 9, 10), 0);
    }

    /** Resize copies in deque order to index 0, resets front to 0, THEN adds (so front wraps to 17). */
    @Test(timeout = TIMEOUT)
    public void testAddFirstResizeWhileWrapped() {
        fillWrapped();
        deque.addFirst(0);
        assertDeque(arr(18, 3, 2, 1, 4, 5, 6, 7, 8, 9,
            null, null, null, null, null, null, null, null, 0), 17);
    }

    @Test(timeout = TIMEOUT)
    public void testFrontNotResetWhenEmptied() {
        deque.addLast(1);
        deque.addLast(2);
        deque.removeFirst();
        deque.removeFirst();
        assertDeque(arr(9), 2);
        deque.addLast(3);
        deque.addLast(4);
        deque.removeLast();
        deque.removeLast();
        assertDeque(arr(9), 2);
    }

    @Test(timeout = TIMEOUT)
    public void testGetFirstAndLast() {
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.getLast());
        assertDeque(arr(9, 1, 2), 0);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddFirstNull() {
        deque.addFirst(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddLastNull() {
        deque.addLast(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFirstEmpty() {
        deque.removeFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveLastEmpty() {
        deque.removeLast();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetFirstEmpty() {
        deque.getFirst();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetLastEmpty() {
        deque.getLast();
    }

    @Test(timeout = 1000)
    public void testRandomOperations() {
        java.util.ArrayDeque<Object> ref = new java.util.ArrayDeque<>();
        Random rand = new Random(1332);
        for (int step = 1; step <= 400; step++) {
            String op;
            int choice = rand.nextInt(5);
            if (ref.isEmpty() || choice < 2) {
                int value = rand.nextInt(100);
                if (rand.nextBoolean()) {
                    op = "addFirst(" + value + ")";
                    deque.addFirst(value);
                    ref.addFirst(value);
                } else {
                    op = "addLast(" + value + ")";
                    deque.addLast(value);
                    ref.addLast(value);
                }
            } else if (choice == 2) {
                op = "removeFirst()";
                assertEquals(op, ref.removeFirst(), deque.removeFirst());
            } else if (choice == 3) {
                op = "removeLast()";
                assertEquals(op, ref.removeLast(), deque.removeLast());
            } else {
                op = "getFirst()/getLast()";
                assertEquals("getFirst()", ref.getFirst(), deque.getFirst());
                assertEquals("getLast()", ref.getLast(), deque.getLast());
            }
            Object[] backing = deque.getBackingArray();
            int front = deque.getFront();
            Object[] expected = new Object[backing.length];
            Object[] values = ref.toArray();
            for (int i = 0; i < values.length; i++) {
                expected[(front + i) % backing.length] = values[i];
            }
            assertEquals("size() after step " + step + " " + op, ref.size(), deque.size());
            assertArrayEquals("backing array after step " + step + " " + op + " (front = " + front + ")",
                expected, backing);
        }
    }

    // ------------------------------------------------------------- helpers

    /** Fills to capacity 9 holding 3,2,1,4,5,6,7,8,9 with front = 6. */
    private void fillWrapped() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        for (int i = 4; i <= 9; i++) {
            deque.addLast(i);
        }
        assertDeque(new Object[] {4, 5, 6, 7, 8, 9, 3, 2, 1}, 6);
    }

    private void assertDeque(Object[] expectedBacking, int expectedFront) {
        int expectedSize = 0;
        for (Object o : expectedBacking) {
            if (o != null) {
                expectedSize++;
            }
        }
        assertEquals("size()", expectedSize, deque.size());
        assertArrayEquals("backing array", expectedBacking, deque.getBackingArray());
        assertEquals("front index", expectedFront, deque.getFront());
    }

    private static Object[] arr(int length, Object... vals) {
        Object[] a = new Object[length];
        System.arraycopy(vals, 0, a, 0, vals.length);
        return a;
    }
}
