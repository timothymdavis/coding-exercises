package spike.datastructures.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

public class LinkedListUtility {

    /**
     * This method assumes that we can't or haven't stored any metadata about our linked list, such as the length.
     */
    public static <T> T getMiddleValue(LinkedList<T> list) {
        Objects.requireNonNull(list);
        LinkedList<T> middle = list;
        while (list != null) {
            list = list.getNext();
            if (list != null) {
                if (list.getNext() != null) {
                    middle = middle.getNext();
                }
                list = list.getNext();
            }
        }
        return middle.getValue();
    }

    @SafeVarargs
    public static <T> LinkedList<T> createLinkedList(T... elements) {
        LinkedList<T> result = null;
        LinkedList<T> list = null;
        for (T element : elements) {
            if (result == null) {
                result = new LinkedList<>(element);
                list = result;
            }
            else {
                list.setNext(new LinkedList<>(element));
                list = list.getNext();
            }
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class LinkedList<T> {
        private final T value;
        private LinkedList<T> next;
    }

}
