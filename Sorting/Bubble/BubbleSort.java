package Sorting.Bubble;

import Sorting.RandomData.RandomInteger;

public class BubbleSort {
    public static void main(String[] oskhar) {
        int size = 10000;
        int[] randomArray = RandomInteger.generateRandomArray(size);

        for (int number : randomArray) {
            System.out.println(number);
        }
        for (int i = 0; i < randomArray.length - 1; i++) {
            for (int j = 0; j < randomArray.length - i - 1; j++) {
                if (randomArray[j] > randomArray[j + 1]) {
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j + 1];
                    randomArray[j + 1] = temp;
                }
            }
        }
        for (int number : randomArray) {
            System.out.print(number + "\n");
        }
    }

}
