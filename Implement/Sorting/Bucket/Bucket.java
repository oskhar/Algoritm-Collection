package Implement.Sorting.Bucket;

public class Bucket {
    public static void handle(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int n = arr.length;
        int[][] buckets = new int[n][n];

        // Initialize buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new int[n];
        }

        // Add elements to buckets
        for (int item : arr) {
            int index = (int) (item * n);
            for (int i = 0; i < n; i++) {
                if (buckets[index][i] == 0) {
                    buckets[index][i] = item;
                    break;
                }
            }
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // Concatenate buckets
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (buckets[i][j] != 0) {
                    arr[index++] = buckets[i][j];
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
