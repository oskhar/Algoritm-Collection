package Implement.Sorting.Merge;

public class MergeTemp {

    public static void handle(int[] data) {
        int[] tempArr = new int[data.length];
        mergesort(data, tempArr, 0, data.length - 1);
    }

    private static void mergesort(int[] data, int[] tempArr, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(data, tempArr, low, middle);
        mergesort(data, tempArr, middle + 1, high);
        merge(data, tempArr, low, middle, high);
    }

    private static void merge(int[] data, int[] tempArr, int low, int middle, int high) {

        System.arraycopy(data, low, tempArr, low, high + 1 - low);

        int firstSubArrCounter = low;
        int secondSubArrCounter = middle + 1;
        int arrCounter = low;
        while (firstSubArrCounter <= middle && secondSubArrCounter <= high) {
            data[arrCounter++] = (tempArr[firstSubArrCounter] <= tempArr[secondSubArrCounter])
                    ? tempArr[firstSubArrCounter++]
                    : tempArr[secondSubArrCounter++];
        }

        while (firstSubArrCounter <= middle) {
            data[arrCounter++] = tempArr[firstSubArrCounter++];
        }

        while (secondSubArrCounter <= high) {
            data[arrCounter++] = tempArr[secondSubArrCounter++];
        }
    }
}
