package spike.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class DivisibleSumPairsTest extends HackerRankTest {

    public DivisibleSumPairsTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> setUpScanners() throws IOException {
        TestContext context = getTestContext("/hackerrank/divisible-sum-pairs-input.txt", "/hackerrank/divisible-sum-pairs-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankBoilerplate.singleTestCase(s -> {
            int arraySize = s.nextInt();
            DivisibleSumPairs.solve(s.nextInt(), HackerRankBoilerplate.nextArray(arraySize, s::nextInt, Integer[]::new));
            String actualLine = context.getActualScanner().nextLine();
            String expectedLine = context.getExpectedScanner().nextLine();
            arguments.add(new String[]{actualLine, expectedLine});
        });

        return arguments;
    }

}