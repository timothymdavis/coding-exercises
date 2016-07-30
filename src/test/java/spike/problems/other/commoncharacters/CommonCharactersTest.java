package spike.problems.other.commoncharacters;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CommonCharactersTest {

    @Test
    public void testNSquared() throws Exception {
        assertThat(CommonCharacters.nSquared("ace", "bcd"), is("c"));
        assertThat(CommonCharacters.nSquared("abce", "bcd"), is("bc"));
        assertThat(CommonCharacters.nSquared("ace", "bd"), is(""));
    }

    @Test
    public void testN() throws Exception {
        assertThat(CommonCharacters.n("ace", "bcd"), is("c"));
        assertThat(CommonCharacters.n("abce", "bcd"), is("bc"));
        assertThat(CommonCharacters.n("ace", "bd"), is(""));
    }
}