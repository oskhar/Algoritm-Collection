package Implement.Sorting.Bucket;

import Implement.Sorting.RandomData.RandomInteger;

public class Bucket {
    public static void handle(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int n = arr.length;
        int maxValue = findMaxValue(arr);
        int numberOfBuckets = (int) Math.sqrt(n);

        // Create buckets
        int[][] buckets = new int[numberOfBuckets][n];
        int[] bucketSizes = new int[numberOfBuckets];

        // Distribute input array values into buckets
        for (int item : arr) {
            int bucketIndex = (item * numberOfBuckets) / (maxValue + 1);
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = item;
        }

        // Sort each bucket and concatenate
        int index = 0;
        for (int i = 0; i < numberOfBuckets; i++) {
            insertionSort(buckets[i], bucketSizes[i]);
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }

    private static void insertionSort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
}
