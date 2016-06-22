package spike.sorting;

import org.junit.Test;

import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUtilTest {

    @Test
    public void testInsertionSort() throws Exception {
        assertSort(SortUtil::insertionSort);
    }

    @Test
    public void testMergeSort() throws Exception {
        assertSort(SortUtil::mergeSort);
    }

    @Test
    public void testQuickSort() throws Exception {
        assertSort(SortUtil::quickSort);
    }

    private void assertSort(Consumer<int[]> sorter) {
        for (int[][] testData : getTestData()) {
            sorter.accept(testData[0]);
            assertThat(testData[0], is(testData[1]));
        }
    }

    private int[][][] getTestData() {
        return new int[][][]{
                //    actual     |    expected
                {{5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}},
                {{9, 3, 6, 2, 10}, {2, 3, 6, 9, 10}},
                {{-9, 3, 60, 2, 10}, {-9, 2, 3, 10, 60}},
                {{1}, {1}},
        };
    }

}