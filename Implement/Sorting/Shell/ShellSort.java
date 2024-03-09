package Implement.Sorting.Shell;

import java.util.stream.IntStream;

public record ShellSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j].compareTo(arr[j - gap]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }

    public void sortRecursively() {
        IntStream.iterate(arr.length / 2, gap -> gap > 0, gap -> gap / 2)
                .forEach(gap -> IntStream.range(gap, arr.length).forEach(index -> sort(index, gap)));
    }

    private void sort(int index, int gap) {
        if (index >= gap && arr[index].compareTo(arr[index - gap]) < 0) {
            T temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            sort(index - gap, gap);
        }
    }

}
