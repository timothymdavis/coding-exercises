package spike.problems.hackerrank;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@AllArgsConstructor
public abstract class HackerRankTest {

    private final String actual;
    private final String expected;

    protected static TestContext getTestContext(String inputFileName, String outputFileName) throws IOException {
        InputStream inputIS = HackerRankTest.class.getResourceAsStream(inputFileName);
        InputStream expectedOS = HackerRankTest.class.getResourceAsStream(outputFileName);
        PipedOutputStream actualOS = new PipedOutputStream();
        InputStream actualIS = new PipedInputStream(actualOS);

        System.setIn(inputIS);
        System.setOut(new PrintStream(actualOS));

        Scanner actualScanner = new Scanner(actualIS);
        Scanner expectedScanner = new Scanner(expectedOS);

        return new TestContext(actualScanner, expectedScanner);
    }

    protected static void populateTestArguments(TestContext context, List<Object> arguments) {
        Scanner actualScanner = context.getActualScanner();
        Scanner expectedScanner = context.getExpectedScanner();
        String actualLine = actualScanner.nextLine();
        String expectedLine = expectedScanner.nextLine();
        arguments.add(new String[]{actualLine.trim(), expectedLine.trim()});
    }

    @Test
    public void verifyTestCase() {
        assertThat(actual, equalTo(expected));
    }

    @Data
    public static class TestContext {
        private final Scanner actualScanner;
        private final Scanner expectedScanner;
    }

}