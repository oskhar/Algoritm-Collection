package Sorting.Insertion;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Tyrion", "Arya", "Daenerys", "Sansa", "Cersei" };
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new InsertionSort<>(integers).sort();
        new InsertionSort<>(strings).sortWithStreams();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

}
