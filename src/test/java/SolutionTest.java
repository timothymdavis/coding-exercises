import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class SolutionTest {

    private final String actual;
    private final String expected;

    @Parameters
    public static Collection<Object> getData() throws IOException {
        List<Object> arguments = new ArrayList<>();
        InputStream inputIS = SolutionTest.class.getResourceAsStream("/hackerrank/test-input.txt");
        InputStream expectedIS = SolutionTest.class.getResourceAsStream("/hackerrank/test-output.txt");
        PipedOutputStream actualOS = new PipedOutputStream();
        InputStream actualIS = new PipedInputStream(actualOS);

        System.setIn(inputIS);
        System.setOut(new PrintStream(actualOS));

        Scanner actualScanner = new Scanner(actualIS);
        Scanner expectedScanner = new Scanner(expectedIS);

        Solution.Boilerplate.intArrayTestCase(s -> {
            Solution.solve(s);
            String actualLine = actualScanner.nextLine();
            String expectedLine = expectedScanner.nextLine();
            arguments.add(new String[]{actualLine, expectedLine});
        });

        return arguments;
    }

    @Test
    public void verifyTestCase() {
        assertThat(actual, equalTo(expected));
    }

}