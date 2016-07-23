package spike.incrementversion;

import java.util.Stack;

/**
 * Increment a version number by some amount. Don't allow any particular number to exceed 9 (e.g. 2.4.9 would become
 * 2.5.0.)
 */
public class VersionIncrementer {
    
    public static void incrementVersion(Stack<Integer> version, int amountToIncrement) {
        if (version.isEmpty()) {
            version.push(amountToIncrement);
        }
        else {
            int incremented = version.pop() + amountToIncrement;
            if (incremented > 9) {
                incrementVersion(version, incremented / 10);
                version.push(incremented % 10);
            }
            else {
                version.push(incremented);
            }
        }
    }
}
