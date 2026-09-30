package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * JUnit 4 tests for LinkedStack.
 *
 * These walk your nodes directly (not just return values), the same way the
 * real homework graders do.
 */
public class LinkedStackStudentTest {

    private static final int TIMEOUT = 200;

    private LinkedStack<Object> stack;

    @Before
    public void setUp() {
        stack = new LinkedStack<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertStack();
    }

    @Test(timeout = TIMEOUT)
    public void testPush() {
        stack.push(1);
        assertStack(1);
        stack.push(2);
        stack.push(3);
        assertStack(3, 2, 1);
    }

    @Test(timeout = TIMEOUT)
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertStack(2, 1);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertStack();
        stack.push(4);
        assertStack(4);
    }

    @Test(timeout = TIMEOUT)
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertStack(2, 1);
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

    /** Walks from head (the top) and checks the data, the end of the chain, and size. */
    private void assertStack(Object... topToBottom) {
        LinkedStack.Node<Object> cur = stack.getHead();
        for (int i = 0; i < topToBottom.length; i++) {
            assertNotNull("stack ended after " + i + " nodes, expected " + topToBottom.length, cur);
            assertEquals("data at depth " + i, topToBottom[i], cur.getData());
            cur = cur.getNext();
        }
        assertNull("node after the bottom should be null (extra nodes, or a cycle)", cur);
        assertEquals("size()", topToBottom.length, stack.size());
    }
}
