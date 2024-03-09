package Implement.Sorting.Selection;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Sylvanas", "Garrosh", "Varian", "Tyrande", "Gul'dan" };
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new SelectionSort<>(integers).sort();
        new SelectionSort<>(strings).sortWithStreams();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }
}
