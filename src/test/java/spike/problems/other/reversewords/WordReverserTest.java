package spike.problems.other.reversewords;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordReverserTest {

    @Test
    public void testReverseWordsAbcs() {
        assertThat(new WordReverser("abcdefghijklmnopqrstuvwxyz").reverseWords(),
                   is("zyxwvutsrqponmlkjihgfedcba"));
    }

    @Test
    public void testReverseWordsOneSentence() {
        assertThat(new WordReverser("This is  a sentence!").reverseWords(),
                   is("sihT si  a ecnetnes!"));
    }

    @Test
    public void testReverseWordsTwoSentences() {
        assertThat(new WordReverser("This is my first sentence? This is my second sentence.").reverseWords(),
                   is("sihT si ym tsrif ecnetnes? sihT si ym dnoces ecnetnes."));
    }

    @Test
    public void testReverseWordsNewLine() {
        assertThat(new WordReverser("This is my first line;\nThis is my second line.").reverseWords(),
                   is("sihT si ym tsrif enil;\nsihT si ym dnoces enil."));
    }

}