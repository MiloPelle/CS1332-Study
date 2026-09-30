package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * JUnit 4 tests for DoublyLinkedList.
 *
 * These walk your nodes directly (not just return values), the same way the
 * real homework graders do.
 */
public class DoublyLinkedListStudentTest {

    private static final int TIMEOUT = 200;

    private DoublyLinkedList<Object> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertList();
    }

    // ---------------------------------------------------------------- adds

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront(1);
        assertList(1);
        list.addToFront(2);
        list.addToFront(3);
        assertList(3, 2, 1);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack(1);
        assertList(1);
        list.addToBack(2);
        list.addToBack(3);
        assertList(1, 2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontAndBackMixed() {
        list.addToBack(2);
        list.addToFront(1);
        list.addToBack(3);
        list.addToFront(0);
        assertList(0, 1, 2, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexEmpty() {
        list.addAtIndex(0, 5);
        assertList(5);
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        fill(1, 2, 3);
        list.addAtIndex(0, 0);   // front
        assertList(0, 1, 2, 3);
        list.addAtIndex(4, 4);   // back
        assertList(0, 1, 2, 3, 4);
        list.addAtIndex(2, 9);   // middle
        assertList(0, 1, 9, 2, 3, 4);
        list.addAtIndex(5, 8);   // just before the tail
        assertList(0, 1, 9, 2, 3, 8, 4);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexNegative() {
        list.addAtIndex(-1, 1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexGreaterThanSize() {
        list.addToBack(1);
        list.addAtIndex(2, 1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddAtIndexNull() {
        list.addAtIndex(0, null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToFrontNull() {
        list.addToFront(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddToBackNull() {
        list.addToBack(null);
    }

    // ------------------------------------------------------------- removes

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        fill(0, 1, 2, 3, 4);
        assertEquals(2, list.removeAtIndex(2));   // middle
        assertList(0, 1, 3, 4);
        assertEquals(4, list.removeAtIndex(3));   // last
        assertList(0, 1, 3);
        assertEquals(0, list.removeAtIndex(0));   // first
        assertList(1, 3);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        fill(1, 2, 3);
        assertEquals(1, list.removeFromFront());
        assertList(2, 3);
        assertEquals(2, list.removeFromFront());
        assertList(3);
        assertEquals(3, list.removeFromFront());
        assertList();
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        fill(1, 2, 3);
        assertEquals(3, list.removeFromBack());
        assertList(1, 2);
        assertEquals(2, list.removeFromBack());
        assertList(1);
        assertEquals(1, list.removeFromBack());
        assertList();
    }

    /** Catches head/tail pointers that aren't cleaned up when the list empties. */
    @Test(timeout = TIMEOUT)
    public void testReuseAfterEmptied() {
        list.addToBack(1);
        list.removeFromFront();
        list.addToBack(2);
        assertList(2);
        list.removeFromBack();
        list.addToFront(3);
        assertList(3);
        list.removeAtIndex(0);
        list.addToBack(4);
        list.addToBack(5);
        assertList(4, 5);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexNegative() {
        list.addToBack(1);
        list.removeAtIndex(-1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexEqualToSize() {
        list.addToBack(1);
        list.removeAtIndex(1);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromFrontEmpty() {
        list.removeFromFront();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveFromBackEmpty() {
        list.removeFromBack();
    }

    // ------------------------------------------------- removeLastOccurrence

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrence() {
        fill(1, 2, 1, 3, 1);
        assertEquals(1, list.removeLastOccurrence(1));
        assertList(1, 2, 1, 3);
        assertEquals(1, list.removeLastOccurrence(1));
        assertList(1, 2, 3);
        assertEquals(3, list.removeLastOccurrence(3));
        assertList(1, 2);
        assertEquals(2, list.removeLastOccurrence(2));
        assertList(1);
        assertEquals(1, list.removeLastOccurrence(1));
        assertList();
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrenceAtHead() {
        fill(4, 5, 6);
        assertEquals(4, list.removeLastOccurrence(4));
        assertList(5, 6);
    }

    /** Must compare with equals() and return the object stored in the list. */
    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrenceReturnsStoredData() {
        String stored = new String("dup");
        list.addToBack("a");
        list.addToBack(stored);
        list.addToBack("b");
        Object removed = list.removeLastOccurrence(new String("dup"));
        assertSame("return the data stored in the list, not the argument", stored, removed);
        assertList("a", "b");
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveLastOccurrenceNull() {
        list.addToBack(1);
        list.removeLastOccurrence(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveLastOccurrenceNotFound() {
        fill(1, 2);
        list.removeLastOccurrence(7);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveLastOccurrenceEmpty() {
        list.removeLastOccurrence(1);
    }

    // ------------------------------------------------------------- others

    @Test(timeout = TIMEOUT)
    public void testGet() {
        fill(5, 6, 7, 8);
        for (int i = 0; i < 4; i++) {
            assertEquals(5 + i, list.get(i));
        }
        assertList(5, 6, 7, 8);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetNegative() {
        list.addToBack(1);
        list.get(-1);
    }

    @Test(timeout = TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testGetEqualToSize() {
        list.addToBack(1);
        list.get(1);
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyAndClear() {
        assertTrue(list.isEmpty());
        fill(1, 2);
        assertFalse(list.isEmpty());
        list.clear();
        assertList();
        assertTrue(list.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {
        assertArrayEquals(new Object[0], list.toArray());
        fill(1, 2, 3);
        assertArrayEquals(new Object[] {1, 2, 3}, list.toArray());
    }

    @Test(timeout = 1000)
    public void testRandomOperations() {
        List<Object> ref = new LinkedList<>();
        Random rand = new Random(1332);
        for (int step = 1; step <= 400; step++) {
            String op;
            int choice = rand.nextInt(7);
            if (ref.isEmpty() || choice < 3) {
                int value = rand.nextInt(6);
                int kind = rand.nextInt(3);
                if (kind == 0) {
                    op = "addToFront(" + value + ")";
                    list.addToFront(value);
                    ref.add(0, value);
                } else if (kind == 1) {
                    op = "addToBack(" + value + ")";
                    list.addToBack(value);
                    ref.add(value);
                } else {
                    int index = rand.nextInt(ref.size() + 1);
                    op = "addAtIndex(" + index + ", " + value + ")";
                    list.addAtIndex(index, value);
                    ref.add(index, value);
                }
            } else if (choice == 3) {
                int index = rand.nextInt(ref.size());
                op = "removeAtIndex(" + index + ")";
                assertEquals(op, ref.remove(index), list.removeAtIndex(index));
            } else if (choice == 4) {
                op = "removeFromFront()";
                assertEquals(op, ref.remove(0), list.removeFromFront());
            } else if (choice == 5) {
                op = "removeFromBack()";
                assertEquals(op, ref.remove(ref.size() - 1), list.removeFromBack());
            } else {
                Object value = ref.get(rand.nextInt(ref.size()));
                op = "removeLastOccurrence(" + value + ")";
                ref.remove(ref.lastIndexOf(value));
                assertEquals(op, value, list.removeLastOccurrence(value));
            }
            try {
                assertList(ref.toArray());
            } catch (AssertionError e) {
                throw new AssertionError("after step " + step + " " + op + ": " + e.getMessage(), e);
            }
        }
    }

    // ------------------------------------------------------------- helpers

    private void fill(Object... data) {
        for (Object d : data) {
            list.addToBack(d);
        }
    }

    // ===== STRUCTURE CHECK =====

    /**
     * Walks the nodes from head and checks the data, every previous pointer,
     * that the last node's next is null, that tail is the last node, and size.
     */
    private void assertList(Object... expected) {
        DoublyLinkedList.Node<Object> cur = list.getHead();
        DoublyLinkedList.Node<Object> last = null;
        for (int i = 0; i < expected.length; i++) {
            assertNotNull("list ended after " + i + " nodes, expected " + expected.length, cur);
            assertEquals("data at index " + i, expected[i], cur.getData());
            if (cur.getPrevious() != last) {
                fail("previous pointer of index " + i + " should be " + describe(last)
                    + " but is " + describe(cur.getPrevious()));
            }
            last = cur;
            cur = cur.getNext();
        }
        assertNull("node after index " + (expected.length - 1)
            + " should be null (extra nodes, or a cycle)", cur);
        if (last != list.getTail()) {
            fail("tail should be " + describe(last) + " but is " + describe(list.getTail()));
        }
        assertEquals("size()", expected.length, list.size());
    }

    private static String describe(DoublyLinkedList.Node<Object> node) {
        return node == null ? "null" : "the node holding " + node.getData();
    }
}
