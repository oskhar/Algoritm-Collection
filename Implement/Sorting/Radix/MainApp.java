package Implement.Sorting.Radix;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        int[] arr = { 1012, 5221, 2212, 3234, -3417, -1532, -1020, -1012, -5221, -2212, -3234, 3417, 1532, 1020 };
        System.out.println(Arrays.toString(arr));
        new RadixSort(arr).sort();
        System.out.println(Arrays.toString(arr));

    }

}
