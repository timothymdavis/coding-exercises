package spike.reversewords;

/**
 * Reverses the words in a snippet of text, but not the punctuation or whitespace.
 */
public class WordReverser {

    public static final String IGNORED_CHARACTERS = " .?!,;\t\n";

    private final char[] snippet;
    private int startingCursor;
    private int endingCursor;
    
    public WordReverser(String snippet) {
        this.snippet = snippet.toCharArray();
        startingCursor = -1;
        endingCursor = -1;
    }
    
    public String reverseWords() {
        while (nextWord()) {
            reverseCurrentWord();
        }
        return new String(snippet);
    }
    
    private boolean nextWord() {
        startingCursor = endingCursor + 1;
        if (snippet.length <= startingCursor) {
            return false;
        }
        while (IGNORED_CHARACTERS.contains("" + snippet[startingCursor])) {
            startingCursor++;
        }
        endingCursor = startingCursor;
        while (snippet.length > endingCursor && !IGNORED_CHARACTERS.contains("" + snippet[endingCursor])) {
            endingCursor++;
        }
        return true;
    }
    
    private void reverseCurrentWord() {
        char[] temp = new char[endingCursor + 1 - startingCursor];
        int current = 0;
        for (int i = endingCursor - 1; i >= startingCursor; i--) {
            temp[current++] = snippet[i];
        }
        current = 0;
        for (int i = startingCursor; i < endingCursor; i++) {
            snippet[i] = temp[current++];
        }
    }
    
}
