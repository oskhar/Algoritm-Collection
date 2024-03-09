package Implement.Sorting.Heap;

public class Heap {
    public static void handle(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            heapify(data, data.length, i);
        }

        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0);
        }

    }

    public static void heapify(int[] data, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && data[left] > data[largest])
            largest = left;

        if (right < size && data[right] > data[largest])
            largest = right;

        if (largest != i) {
            int temp = data[largest];
            data[largest] = data[i];
            data[i] = temp;

            heapify(data, size, largest);
        }

    }
}
