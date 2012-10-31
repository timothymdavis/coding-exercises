package spike.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MergeSorterTest {

    private void assertThatSorterWorks(Sorter<Integer> sorter, List<Integer> sortableList) {
        List<Integer> sortedList = sorter.sort(sortableList);

        assertThat(sortableList.size(), is(sortedList.size()));

        Object[] javaSortedArray = sortableList.toArray();
        Object[] mySortedArray = sortedList.toArray();

        Arrays.sort(javaSortedArray);

        assertThat(Arrays.equals(javaSortedArray, mySortedArray), equalTo(true));
    }

    @Test
    public void mergeSort() throws Exception {
        assertThatSorterWorks(new MergeSorter<Integer>(), Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void mergeSortWithComparator() throws Exception {
        assertThatSorterWorks(
                new MergeSorter<Integer>(new ComparableAdapter<Integer>()),
                Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void mergeSortWithEmptyList() throws Exception {
        assertThatSorterWorks(new MergeSorter<Integer>(), new ArrayList<Integer>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mergeSortWithNullComparator() throws Exception {
        new MergeSorter<Integer>(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mergeSortWithNullList() throws Exception {
        new MergeSorter<Integer>().sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mergeSortWithNullListItem() throws Exception {
        new MergeSorter<Integer>().sort(Arrays.asList(4, 5, 2, null, 7, 0, -2, 9));
    }

    @Test
    public void mergeSortWithOnlyOneListItem() throws Exception {
        assertThatSorterWorks(new MergeSorter<Integer>(), Arrays.asList(4));
    }

}
