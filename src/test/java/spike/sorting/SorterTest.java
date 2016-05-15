package spike.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SorterTest {

    private void assertThatSorterWorks(Sorter<Integer> sorter, List<Integer> sortableList) {
        List<Integer> sortedList = sorter.sort(sortableList);

        assertThat(sortableList.size(), is(sortedList.size()));

        Object[] javaSortedArray = sortableList.toArray();
        Object[] mySortedArray = sortedList.toArray();

        Arrays.sort(javaSortedArray);

        assertThat(Arrays.equals(javaSortedArray, mySortedArray), equalTo(true));
    }

    @Test
    public void bubbleSort() throws Exception {
        assertThatSorterWorks(new BubbleSorter<>(), Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    @SuppressWarnings("Convert2Diamond")
    public void bubbleSortWithComparator() throws Exception {
        assertThatSorterWorks(
                new BubbleSorter<Integer>(new ComparableAdapter<>()),
                Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void bubbleSortWithEmptyList() throws Exception {
        assertThatSorterWorks(new BubbleSorter<>(), new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void bubbleSortWithNullComparator() throws Exception {
        new BubbleSorter<Integer>(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bubbleSortWithNullList() throws Exception {
        new BubbleSorter<Integer>().sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bubbleSortWithNullListItem() throws Exception {
        new BubbleSorter<Integer>().sort(Arrays.asList(4, 5, 2, null, 7, 0, -2, 9));
    }

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    @Test
    public void bubbleSortWithOnlyOneListItem() throws Exception {
        assertThatSorterWorks(new BubbleSorter<>(), Collections.singletonList(4));
    }

    @Test
    public void mergeSort() throws Exception {
        assertThatSorterWorks(new MergeSorter<>(), Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    @SuppressWarnings("Convert2Diamond")
    public void mergeSortWithComparator() throws Exception {
        assertThatSorterWorks(
                new MergeSorter<Integer>(new ComparableAdapter<>()),
                Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void mergeSortWithEmptyList() throws Exception {
        assertThatSorterWorks(new MergeSorter<>(), new ArrayList<>());
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

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    @Test
    public void mergeSortWithOnlyOneListItem() throws Exception {
        assertThatSorterWorks(new MergeSorter<>(), Collections.singletonList(4));
    }

    @Test
    public void quickSort() throws Exception {
        assertThatSorterWorks(new QuickSorter<>(), Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    @SuppressWarnings("Convert2Diamond")
    public void quickSortWithComparator() throws Exception {
        assertThatSorterWorks(
                new QuickSorter<Integer>(new ComparableAdapter<>()),
                Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void quickSortWithEmptyList() throws Exception {
        assertThatSorterWorks(new QuickSorter<>(), new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void quickSortWithNullComparator() throws Exception {
        new QuickSorter<Integer>(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void quickSortWithNullList() throws Exception {
        new QuickSorter<Integer>().sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void quickSortWithNullListItem() throws Exception {
        new QuickSorter<Integer>().sort(Arrays.asList(4, 5, 2, null, 7, 0, -2, 9));
    }

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    @Test
    public void quickSortWithOnlyOneListItem() throws Exception {
        assertThatSorterWorks(new QuickSorter<>(), Collections.singletonList(4));
    }

    @Test
    public void insertionSort() throws Exception {
        assertThatSorterWorks(new InsertionSorter<>(), Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    @SuppressWarnings("Convert2Diamond")
    public void insertionSortWithComparator() throws Exception {
        assertThatSorterWorks(
                new InsertionSorter<Integer>(new ComparableAdapter<>()),
                Arrays.asList(4, 5, 2, 7, 0, -2, 9));
    }

    @Test
    public void insertionSortWithEmptyList() throws Exception {
        assertThatSorterWorks(new InsertionSorter<>(), new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertionSortWithNullComparator() throws Exception {
        new InsertionSorter<Integer>(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertionSortWithNullList() throws Exception {
        new InsertionSorter<Integer>().sort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertionSortWithNullListItem() throws Exception {
        new InsertionSorter<Integer>().sort(Arrays.asList(4, 5, 2, null, 7, 0, -2, 9));
    }

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    @Test
    public void insertionSortWithOnlyOneListItem() throws Exception {
        assertThatSorterWorks(new InsertionSorter<>(), Collections.singletonList(4));
    }

}
