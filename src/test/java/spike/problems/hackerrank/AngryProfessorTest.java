package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spike.problems.hackerrank.HackerRankTestHelper.nextArray;

@RunWith(Parameterized.class)
public class AngryProfessorTest extends HackerRankTest {

    public AngryProfessorTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/angry-professor-input.txt", "/hackerrank/angry-professor-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.multiTestCase(s -> {
            int arraySize = s.nextInt();
            AngryProfessor.solve(s.nextInt(), nextArray(arraySize, s::nextInt, Integer[]::new));
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}