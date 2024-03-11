package Implement.Sorting.Radix;

public class Radix {

    public static void handle(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp, arr);
        }
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void countSort(int exp, int[] arr) {
        int[] output = new int[arr.length];
        int[] countArray = new int[10];

        for (int value : arr) {
            countArray[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = countArray[(current / exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

}
