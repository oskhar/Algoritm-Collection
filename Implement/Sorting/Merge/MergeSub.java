package Implement.Sorting.Merge;

public class MergeSub {

    public static void handle(int[] data) {
        mergesort(data, 0, data.length - 1);
    }

    private static void mergesort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(data, low, middle);
        mergesort(data, middle + 1, high);
        merge(data, low, middle, high);
    }

    private static void merge(int[] data, int low, int middle, int high) {

        int[] leftArray = new int[middle - low + 1];
        int[] rightArray = new int[high - middle];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = data[low + i];
        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = data[middle + 1 + i];
        }

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            data[arrCounter++] = leftArray[leftSubArrCounter] <= rightArray[rightSubArrCounter]
                    ? leftArray[leftSubArrCounter++]
                    : rightArray[rightSubArrCounter++];
        }

        while (leftSubArrCounter < leftArray.length) {
            data[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        while (rightSubArrCounter < rightArray.length) {
            data[arrCounter++] = rightArray[rightSubArrCounter++];
        }
    }
}
