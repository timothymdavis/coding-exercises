package spike.sorting;

public final class SortUtil {

    private SortUtil() {}

    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int curr = a[i];
            int j = i;
            while (j > 0 && curr < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = curr;
        }
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (end - start > 1) {
            int middle = start + ((end - start) / 2);
            mergeSort(a, start, middle);
            mergeSort(a, middle, end);
            merge(a, start, middle, end);
        }
    }

    private static void merge(int[] a, int start, int middle, int end) {
        int[] m = new int[end - start + 1];
        int l = 0, r = 0, i = 0;

        while (l < middle - start && r < end - middle) {
            m[i++] = a[start + l] < a[middle + r] ? a[start + l++] : a[middle + r++];
        }

        while (l < middle - start) {
            m[i++] = a[start + l++];
        }

        while (r < end - middle) {
            m[i++] = a[middle + r++];
        }

        System.arraycopy(m, 0, a, start, m.length - 1);
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {
        if (end - start > 0) {
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivotValue = a[end];
        while (start != end) {
            if (a[start] < pivotValue) {
                start++;
            }
            else {
                a[end] = a[start];
                a[start] = a[--end];
            }
        }
        a[end] = pivotValue;
        return end;
    }

}
