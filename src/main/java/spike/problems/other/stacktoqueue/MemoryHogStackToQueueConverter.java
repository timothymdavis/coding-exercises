package spike.problems.other.stacktoqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Attempt using two stacks to reverse the list items. Solution is O(2n) since we loop through every element
 * twice. Note: depending upon the implementation of {@link Stack} and {@link Queue} this approach may not
 * actually be terribly memory intensive. In this case, the Java implementation of {@link Stack} is based upon
 * {@link java.util.Vector}, which uses an array internally. The size of the array grows as needed, but not
 * necessarily with each push/pop. I've chosen {@link LinkedList} as my {@link Queue} implementation,
 * so that it is less memory intensive.
 */
public class MemoryHogStackToQueueConverter<A> implements StackToQueueConverter<A> {

    @Override
    public Queue<A> to(Stack<A> stack) {
        stack = stack != null ? stack : new Stack<>();
        Stack<A> tempStack = new Stack<>();
        Queue<A> queue = new LinkedList<>();

        while (!stack.isEmpty()) {
            A item = stack.pop();
            tempStack.push(item);
        }

        while (!tempStack.isEmpty()) {
            A item = tempStack.pop();
            queue.add(item);
        }

        return queue;
    }

}


