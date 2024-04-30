package Implement.Sorting.RandomData;

import java.util.Random;

public class ShuffleArray {

    public static void handle(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
