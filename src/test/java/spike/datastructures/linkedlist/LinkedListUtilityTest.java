package spike.datastructures.linkedlist;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static spike.datastructures.linkedlist.LinkedListUtility.LinkedList;

public class LinkedListUtilityTest {

    @Test(expected = NullPointerException.class)
    public void testGetMiddleValueWithNullEntry() throws Exception {
        LinkedListUtility.getMiddleValue(null);
    }

    @Test
    public void testGetMiddleValueWithOneEntry() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a");
        assertThat(LinkedListUtility.getMiddleValue(list), is("a"));
    }

    @Test
    public void testGetMiddleValueWithTwoEntries() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a", "b");
        assertThat(LinkedListUtility.getMiddleValue(list), is("a"));
    }

    @Test
    public void testGetMiddleValueWithThreeEntries() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a", "b", "c");
        assertThat(LinkedListUtility.getMiddleValue(list), is("b"));
    }

    @Test
    public void testGetMiddleValueWithFourEntries() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a", "b", "c", "d");
        assertThat(LinkedListUtility.getMiddleValue(list), is("b"));
    }

    @Test
    public void testGetMiddleValueWithNineEntries() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a", "b", "c", "d", "e", "f", "g", "h", "i");
        assertThat(LinkedListUtility.getMiddleValue(list), is("e"));
    }

    @Test
    public void testGetMiddleValueWithTenEntries() throws Exception {
        LinkedList<String> list = LinkedListUtility.createLinkedList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        assertThat(LinkedListUtility.getMiddleValue(list), is("e"));
    }

}