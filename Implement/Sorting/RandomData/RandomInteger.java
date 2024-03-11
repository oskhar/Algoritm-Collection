package Implement.Sorting.RandomData;

import java.util.Random;

public class RandomInteger {
    public static int size = 1000000;

    public static int[] generateRandomArray() {
        int max = size;
        int min = 1;

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + 1;
        }

        return array;
    }
}
