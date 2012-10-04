package spike.stacktoqueue;

import java.util.Queue;
import java.util.Stack;

import junit.framework.Assert;
import org.junit.Test;

public class StackToQueueConverterTest {
    
    private void assertThatConversionWorks(StackToQueueConverter<Integer> converter) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Queue<Integer> queue = converter.to(stack);

        Assert.assertEquals(1, (int) queue.remove());
        Assert.assertEquals(2, (int) queue.remove());
        Assert.assertEquals(3, (int) queue.remove());
        Assert.assertEquals(4, (int) queue.remove());
        Assert.assertEquals(5, (int) queue.remove());
    }

    @Test
    public void stackProblemCpuHog() {
        assertThatConversionWorks(new MemoryHogStackToQueueConverter<Integer>());
    }

    @Test
    public void stackProblemMemoryHog() {
        assertThatConversionWorks(new CpuHogStackToQueueConverter<Integer>());
    }

    @Test
    public void stackProblemWithNullInput() {
        Assert.assertTrue(new CpuHogStackToQueueConverter<Integer>().to(null).isEmpty());
        Assert.assertTrue(new MemoryHogStackToQueueConverter<Integer>().to(null).isEmpty());
    }

}
