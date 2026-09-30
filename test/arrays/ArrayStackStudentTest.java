package arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * JUnit 4 tests for ArrayStack.
 *
 * These check your backing array directly (not just return values), the same
 * way the real homework graders do.
 */
public class ArrayStackStudentTest {

    private static final int TIMEOUT = 200;

    private ArrayStack<Object> stack;

    @Before
    public void setUp() {
        stack = new ArrayStack<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, stack.size());
        assertArrayEquals(new Object[ArrayStack.INITIAL_CAPACITY], stack.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertBacking(arr(9, 1, 2, 3));
    }

    @Test(timeout = TIMEOUT)
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertBacking(arr(9, 1, 2));
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertBacking(arr(9));
    }

    @Test(timeout = TIMEOUT)
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertBacking(arr(9, 1, 2));
    }

    @Test(timeout = TIMEOUT)
    public void testPushResizeAndPopDoesNotShrink() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertBacking(arr(18, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 9; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertBacking(arr(18));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPushNull() {
        stack.push(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testPopEmpty() {
        stack.pop();
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        stack.peek();
    }

    // ------------------------------------------------------------- helpers

    private void assertBacking(Object[] expected) {
        int expectedSize = 0;
        for (Object o : expected) {
            if (o != null) {
                expectedSize++;
            }
        }
        assertEquals("size()", expectedSize, stack.size());
        assertArrayEquals("backing array", expected, stack.getBackingArray());
    }

    private static Object[] arr(int length, Object... vals) {
        Object[] a = new Object[length];
        System.arraycopy(vals, 0, a, 0, vals.length);
        return a;
    }
}
