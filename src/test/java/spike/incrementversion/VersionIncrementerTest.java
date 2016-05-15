package spike.incrementversion;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VersionIncrementerTest {
    
    @Test
    public void testIncrementVersionEmptyStackBy1() {
        Stack<Integer> version = new Stack<>();
        VersionIncrementer.incrementVersion(version, 1);
        assertThat(version.toArray(), is(new Integer[] { 1 }));
    }

    @Test
    public void testIncrementVersion249By1() {
        Stack<Integer> version = new Stack<>();
        Arrays.asList(2,4,9).forEach(version::push);
        VersionIncrementer.incrementVersion(version, 1);
        assertThat(version.toArray(), is(new Integer[] { 2,5,0 }));
    }
    
    @Test
    public void testIncrementVersion249By1000() {
        Stack<Integer> version = new Stack<>();
        Arrays.asList(2,4,9).forEach(version::push);
        VersionIncrementer.incrementVersion(version, 1000);
        assertThat(version.toArray(), is(new Integer[] { 1,2,4,9 }));
    }

}