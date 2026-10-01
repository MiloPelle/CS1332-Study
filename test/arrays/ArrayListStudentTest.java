package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit 4 tests for ArrayList.
 *
 * These check your backing array directly (not just return values), the same
 * way the real homework graders do.
 */
public class ArrayListStudentTest {

    private static final int TIMEOUT = 200;

    private ArrayList<Object> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertArrayEquals(new Object[ArrayList.INITIAL_CAPACITY], list.getBackingArray());
    }

    // ---------------------------------------------------------------- adds

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        for (int i = 1; i <= 4; i++) {
            list.addToBack(i);
        }
        assertBacking(arr(9, 1, 2, 3, 4));
    }

    @Test(timeout =      TIMEOUT)
    public void testAddToFront() {
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        assertBacking(arr(9, 3, 2, 1));
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, 1);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 3);
        assertBacking(arr(9, 1, 2, 3));

        list.addAtIndex(0, 0);   // front
        list.addAtIndex(4, 4);   // back
        list.addAtIndex(2, 9);   // middle
        assertBacking(arr(9, 0, 1, 9, 2, 3, 4));
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackResize() {
        for (int i = 0; i < 10; i++) {
            list.addToBack(i);
        }
        assertBacking(arr(18, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontResize() {
        for (int i = 1; i <= 9; i++) {
            list.addToBack(i);
        }
        list.addToFront(0);
        assertBacking(arr(18, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexResize() {
        for (int i = 1; i <= 9; i++) {
            list.addToBack(i);
        }
        list.addAtIndex(4, 99);
        assertBacking(arr(18, 1, 2, 3, 4, 99, 5, 6, 7, 8, 9));
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
        for (int i = 0; i < 5; i++) {
            list.addToBack(i);
        }
        assertEquals(2, list.removeAtIndex(2));   // middle
        assertBacking(arr(9, 0, 1, 3, 4));
        assertEquals(4, list.removeAtIndex(3));   // last
        assertBacking(arr(9, 0, 1, 3));
        assertEquals(0, list.removeAtIndex(0));   // first
        assertBacking(arr(9, 1, 3));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        assertEquals(1, list.removeFromFront());
        assertBacking(arr(9, 2, 3));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        assertEquals(3, list.removeFromBack());
        assertBacking(arr(9, 1, 2));
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveDoesNotShrink() {
        for (int i = 0; i < 10; i++) {
            list.addToBack(i);
        }
        for (int i = 9; i >= 5; i--) {
            assertEquals(i, list.removeFromBack());
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.removeFromFront());
        }
        assertBacking(arr(18));
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

    // ------------------------------------------------------------- others

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addToBack(5);
        list.addToBack(6);
        list.addToBack(7);
        assertEquals(5, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(7, list.get(2));
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
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addToBack(1);
        assertFalse(list.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testClearResetsCapacity() {
        for (int i = 0; i < 10; i++) {
            list.addToBack(i);
        }
        list.clear();
        assertBacking(arr(9));
    }

    @Test(timeout = 1000)
    public void testRandomOperations() {
        List<Object> ref = new java.util.ArrayList<>();
        Random rand = new Random(1332);
        for (int step = 1; step <= 400; step++) {
            String op;
            int choice = rand.nextInt(6);
            if (ref.isEmpty() || choice < 3) {
                int value = rand.nextInt(100);
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
            } else {
                op = "removeFromBack()";
                assertEquals(op, ref.remove(ref.size() - 1), list.removeFromBack());
            }
            Object[] backing = list.getBackingArray();
            Object[] expected = new Object[backing.length];
            for (int i = 0; i < ref.size(); i++) {
                expected[i] = ref.get(i);
            }
            assertEquals("size() after step " + step + " " + op, ref.size(), list.size());
            assertArrayEquals("backing array after step " + step + " " + op, expected, backing);
        }
    }

    // ------------------------------------------------------------- helpers

    /** Checks size and the exact contents (including nulls) of the backing array. */
    private void assertBacking(Object[] expected) {
        int expectedSize = 0;
        for (Object o : expected) {
            if (o != null) {
                expectedSize++;
            }
        }
        assertEquals("size()", expectedSize, list.size());
        assertArrayEquals("backing array", expected, list.getBackingArray());
    }

    /** An array of the given length holding vals at the start and null after. */
    private static Object[] arr(int length, Object... vals) {
        Object[] a = new Object[length];
        System.arraycopy(vals, 0, a, 0, vals.length);
        return a;
    }
}
