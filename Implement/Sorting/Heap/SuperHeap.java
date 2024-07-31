package Implement.Sorting.Heap;

public class SuperHeap {

    public static void sort(long[] data) {
        int n = data.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            long temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // call max heapify on the reduced heap
            heapify(data, i, 0);
        }
    }

    private static void heapify(long[] data, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && data[left] > data[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && data[right] > data[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            long swap = data[i];
            data[i] = data[largest];
            data[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(data, n, largest);
        }
    }
}
