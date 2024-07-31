package Implement.Sorting.Large;

// HeapSort.java
public class HeapSort {
    public static void sort(long[] data) {
        int n = data.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            long temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0);
        }
    }

    private static void heapify(long[] data, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data[left] > data[largest]) {
            largest = left;
        }

        if (right < n && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != i) {
            long swap = data[i];
            data[i] = data[largest];
            data[largest] = swap;

            heapify(data, n, largest);
        }
    }
}