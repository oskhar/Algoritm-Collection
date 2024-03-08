package Sorting.Insertion;

import java.util.stream.IntStream;

public record InsertionSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public void sortWithStreams() {
        IntStream.range(1, arr.length)
                .forEach(i -> IntStream.iterate(i, j -> j > 0 && arr[j].compareTo(arr[j - 1]) < 0, j -> j - 1)
                        .forEach(j -> {
                            T temp = arr[j];
                            arr[j] = arr[j - 1];
                            arr[j - 1] = temp;
                        }));
    }

    public void sortRecursively() {
        IntStream.range(1, arr.length).forEach(this::sort);
    }

    private void sort(int index) {
        if (index > 0 && arr[index].compareTo(arr[index - 1]) < 0) {
            T temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            sort(index - 1);
        }
    }

}
