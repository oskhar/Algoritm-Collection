package Implement.Sorting.Bucket;

import Implement.Sorting.RandomData.RandomInteger;

public class Bucket {
    public static void handle(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int[][] buckets = new int[RandomInteger.size][RandomInteger.size];

        for (int i = 0; i < RandomInteger.size; i++) {
            buckets[i] = new int[RandomInteger.size];
        }

        for (int item : arr) {
            int index = (int) (item * RandomInteger.size);
            for (int i = 0; i < RandomInteger.size; i++) {
                if (buckets[index][i] == 0) {
                    buckets[index][i] = item;
                    break;
                }
            }
        }

        for (int i = 0; i < RandomInteger.size; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < RandomInteger.size; i++) {
            for (int j = 0; j < RandomInteger.size; j++) {
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
