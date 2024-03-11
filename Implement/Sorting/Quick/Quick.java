package Implement.Sorting.Quick;

public class Quick {

    public static void handle(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        quicksort(arr, low, pivot - 1);
        quicksort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotIndexCounter = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot)
                swap(arr, pivotIndexCounter++, i);
        }
        swap(arr, pivotIndexCounter, high);
        return pivotIndexCounter;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }

}
