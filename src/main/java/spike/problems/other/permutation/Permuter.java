package spike.problems.other.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permuter {

    /**
     * Provides a list of all permutations of the characters in {@code str}. For instance:
     * <p/>
     * "ab" -> {@code Arrays.asList("ab", "ba")}
     * <p/>
     * "abc" -> {@code Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")}
     */
    public static List<String> permute(String str) {
        if (str.length() == 1) {
            return new ArrayList<>(Collections.singletonList(str));
        }
        else {
            List<String> result = new ArrayList<>();
            for (Character character : str.toCharArray()) {
                List<String> permutations = permute(str.replace(String.valueOf(character), ""));
                for (int i = 0; i < permutations.size(); i++) {
                    permutations.set(i, character + permutations.get(i));
                }
                result.addAll(permutations);
            }
            return result;
        }
    }

}
