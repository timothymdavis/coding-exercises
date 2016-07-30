package spike.problems.other.stacktoqueue;

import java.util.Queue;
import java.util.Stack;

/**
 * Convert a stack into a queue using only the {@link Stack#push(Object)}, {@link Stack#pop()},
 * {@link Queue#add(Object)}, and {@link Queue#remove()} methods.
 *
 * @param <A> The type of object contained in the stack/queue.
 */
public interface StackToQueueConverter<A> {

    /**
     * Converts a {@link Stack} a {@link Queue}.
     *
     * @param stack the object to convert.
     * @return The converted object.
     */
    Queue<A> to(Stack<A> stack);

}
