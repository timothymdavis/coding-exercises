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

    public static void mergeSort(int[] a, int left, int right) {
        if (right - left > 1) {
            int middle = left + ((right - left) / 2);
            mergeSort(a, left, middle);
            mergeSort(a, middle, right);
            merge(a, left, middle, right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] m = new int[right - left];
        int l = 0, r = 0, i = 0;

        while (l < middle - left && r < right - middle) {
            m[i++] = a[left + l] < a[middle + r] ? a[left + l++] : a[middle + r++];
        }

        while (l < middle - left) {
            m[i++] = a[left + l++];
        }

        while (r < right - middle) {
            m[i++] = a[middle + r++];
        }

        System.arraycopy(m, 0, a, left, right - left);
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int left, int right) {
        if (right - left > 0) {
            int pivot = partition(a, left, right);
            quickSort(a, left, pivot - 1);
            quickSort(a, pivot + 1, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int pivotValue = a[right];
        while (left != right) {
            if (a[left] < pivotValue) {
                left++;
            }
            else {
                a[right] = a[left];
                a[left] = a[--right];
            }
        }
        a[right] = pivotValue;
        return right;
    }

}
