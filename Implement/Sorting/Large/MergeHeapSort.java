package Implement.Sorting.Large;


// MergeHeapSort.java
public class MergeHeapSort {
    public static void sort(long[] data) {
        if (data.length <= 1) return;
        int mid = data.length / 2;

        long[] left = new long[mid];
        long[] right = new long[data.length - mid];

        System.arraycopy(data, 0, left, 0, mid);
        System.arraycopy(data, mid, right, 0, data.length - mid);

        sort(left);
        sort(right);

        merge(data, left, right);
    }

    private static void merge(long[] data, long[] left, long[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }
        while (i < left.length) {
            data[k++] = left[i++];
        }
        while (j < right.length) {
            data[k++] = right[j++];
        }
    }
}