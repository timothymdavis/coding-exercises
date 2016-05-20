package spike.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class PermuterTest {

    @Test
    public void testPermuteOne() throws Exception {
        assertEquals(
                Collections.singletonList("a"),
                Permuter.permute("a"));
    }

    @Test
    public void testPermuteTwo() throws Exception {
        assertEquals(
                Arrays.asList("ab", "ba"),
                Permuter.permute("ab"));
    }

    @Test
    public void testPermuteThree() throws Exception {
        assertEquals(
                Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"),
                Permuter.permute("abc"));
    }

    @Test
    public void testPermuteFour() throws Exception {
        assertEquals(
                Arrays.asList(
                        "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                        "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"),
                Permuter.permute("abcd"));
    }

}