package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spike.problems.hackerrank.HackerRankBoilerplate.nextArray;

@RunWith(Parameterized.class)
public class DivisibleSumPairsTest extends HackerRankTest {

    public DivisibleSumPairsTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/divisible-sum-pairs-input.txt", "/hackerrank/divisible-sum-pairs-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankBoilerplate.singleTestCase(s -> {
            int arraySize = s.nextInt();
            DivisibleSumPairs.solve(s.nextInt(), nextArray(arraySize, s::nextInt, Integer[]::new));
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}