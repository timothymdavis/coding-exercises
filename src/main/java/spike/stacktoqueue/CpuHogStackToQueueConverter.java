package spike.stacktoqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Doesn't use an intermediary data structure, but it requires an extra loop, making the solution O(3n), which is still
 * effectively O(n).
 */
public class CpuHogStackToQueueConverter<A> implements StackToQueueConverter<A> {

    @Override
    public Queue<A> to(Stack<A> stack) {
        stack = stack != null ? stack : new Stack<>();
        Queue<A> queue = new LinkedList<>();

        while (!stack.isEmpty()) {
            A item = stack.pop();
            queue.add(item);
        }

        while (!queue.isEmpty()) {
            A item = queue.remove();
            stack.push(item);
        }

        while (!stack.isEmpty()) {
            A item = stack.pop();
            queue.add(item);
        }

        return queue;
    }

}

