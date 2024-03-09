package Implement.Sorting.Counting;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        int[] arr1 = { 5, 2, 8, 7, -2, 2, 3, 3, 6, 2, 6, -1, 1, 2, 7, -2, 5, 2, 4, 9 };
        System.out.println(Arrays.toString(arr1));
        new Counting(arr1).sort();
        System.out.println(Arrays.toString(arr1));

        System.out.println("==========================================");

        int[] arr2 = { 5, 2, 8, 7, -2, 2, 3, 3, 6, 2, 6, -1, 1, 2, 7, -2, 5, 2, 4, 9 };
        System.out.println(Arrays.toString(arr2));
        new Counting(arr2).countingSort();
        System.out.println(Arrays.toString(arr2));

    }

}
