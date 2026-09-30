package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * JUnit 4 tests for LinkedDeque.
 *
 * These walk your nodes directly (not just return values), the same way the
 * real homework graders do.
 */
public class LinkedDequeStudentTest {

    private static final int TIMEOUT = 200;

    private LinkedDeque<Object> deque;

    @Before
    public void setUp() {
        deque = new LinkedDeque<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertDeque();
    }

    @Test(timeout = TIMEOUT)
    public void testAddFirst() {
        deque.addFirst(1);
        assertDeque(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertDeque(3, 2, 1);
    }

    @Test(timeout = TIMEOUT)
    public void testAddLast() {
        deque.addLast(1);
        assertDeque(1);
        deque.addLast(2);
        deque.addLast(3);
        assertDeque(1, 2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testAddFirstAndLastMixed() {
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);
        assertDeque(1, 2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFirst() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(1, deque.removeFirst());
        assertDeque(2, 3);
        assertEquals(2, deque.removeFirst());
        assertEquals(3, deque.removeFirst());
        assertDeque();
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLast() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.removeLast());
        assertDeque(1, 2);
        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.removeLast());
        assertDeque();
    }

    /** Catches head/tail pointers that aren't cleaned up when the deque empties. */
    @Test(timeout = TIMEOUT)
    public void testReuseAfterEmptied() {
        deque.addFirst(1);
        deque.removeLast();
        deque.addLast(2);
        assertDeque(2);
        deque.removeFirst();
        deque.addFirst(3);
        deque.addLast(4);
        assertDeque(3, 4);
    }

    @Test(timeout = TIMEOUT)
    public void testGetFirstAndLast() {
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(1, deque.getFirst());
        assertEquals(2, deque.getLast());
        assertDeque(1, 2);
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
            int choice = rand.nextInt(4);
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
            } else {
                op = "removeLast()";
                assertEquals(op, ref.removeLast(), deque.removeLast());
            }
            try {
                assertDeque(ref.toArray());
            } catch (AssertionError e) {
                throw new AssertionError("after step " + step + " " + op + ": " + e.getMessage(), e);
            }
        }
    }

    // ------------------------------------------------------------- helpers

    /**
     * Walks from head and checks the data, every previous pointer, that the
     * last node's next is null, that tail is the last node, and size.
     */
    private void assertDeque(Object... frontToBack) {
        LinkedDeque.Node<Object> cur = deque.getHead();
        LinkedDeque.Node<Object> last = null;
        for (int i = 0; i < frontToBack.length; i++) {
            assertNotNull("deque ended after " + i + " nodes, expected " + frontToBack.length, cur);
            assertEquals("data at index " + i, frontToBack[i], cur.getData());
            if (cur.getPrevious() != last) {
                fail("previous pointer of index " + i + " should be " + describe(last)
                    + " but is " + describe(cur.getPrevious()));
            }
            last = cur;
            cur = cur.getNext();
        }
        assertNull("node after the back should be null (extra nodes, or a cycle)", cur);
        if (last != deque.getTail()) {
            fail("tail should be " + describe(last) + " but is " + describe(deque.getTail()));
        }
        assertEquals("size()", frontToBack.length, deque.size());
    }

    private static String describe(LinkedDeque.Node<Object> node) {
        return node == null ? "null" : "the node holding " + node.getData();
    }
}
