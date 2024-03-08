package Sorting.Merge;

@SuppressWarnings("unchecked")
public class MergeSortTemp<T extends Comparable<T>> implements MergeSort {

    private final T[] arr;
    private final T[] tempArr;

    public MergeSortTemp(T[] arr) {
        this.arr = arr;
        tempArr = (T[]) new Comparable[arr.length];
    }

    @Override
    public void sort() {
        mergesort(0, arr.length - 1);
    }

    private void mergesort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {

        if (high + 1 - low >= 0) {
            System.arraycopy(arr, low, tempArr, low, high + 1 - low);
        }

        int firstSubArrCounter = low;
        int secondSubArrCounter = middle + 1;
        int arrCounter = low;
        while (firstSubArrCounter <= middle && secondSubArrCounter <= high) {
            arr[arrCounter++] = (tempArr[firstSubArrCounter].compareTo(tempArr[secondSubArrCounter]) <= 0)
                    ? tempArr[firstSubArrCounter++]
                    : tempArr[secondSubArrCounter++];
        }

        while (firstSubArrCounter <= middle) {
            arr[arrCounter++] = tempArr[firstSubArrCounter++];
        }

        while (secondSubArrCounter <= high) {
            arr[arrCounter++] = tempArr[secondSubArrCounter++];
        }

    }

}
