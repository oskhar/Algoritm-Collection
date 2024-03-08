package Sorting.Quick;

public record QuickSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        quicksort(0, arr.length - 1);
    }

    private void quicksort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(low, high);
        quicksort(low, pivot - 1);
        quicksort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivotIndex = (low + high) / 2;
        swap(pivotIndex, high);
        int pivotIndexCounter = low;
        for (int i = low; i < high; i++) {
            if (arr[i].compareTo(arr[high]) <= 0)
                swap(pivotIndexCounter++, i);
        }
        swap(pivotIndexCounter, high);
        return pivotIndexCounter;
    }

    private void swap(int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            T temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }

}
