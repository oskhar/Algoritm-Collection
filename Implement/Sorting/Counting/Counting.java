package Implement.Sorting.Counting;

public class Counting {

    public static void handle(int[] data) {
        int min = findMin(data);
        int max = findMax(data);

        int[] countArray = new int[max - min + 1];
        for (int value : data) {
            countArray[value - min]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] output = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            int current = data[i];
            int positionInArray = countArray[current - min] - 1;
            output[positionInArray] = current;
            countArray[current - min]--;
        }

        System.arraycopy(output, 0, data, 0, data.length);
    }

    public static void handleDesc(int[] data) {
        int min = findMin(data);
        int max = findMax(data);

        int[] countArray = new int[max - min + 1];
        for (int value : data) {
            countArray[value - min]++;
        }

        int arrayIndex = 0;
        for (int i = max - min; i >= 0; i--) {
            while (countArray[i] > 0) {
                data[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }

    private static int findMin(int[] data) {
        int min = Integer.MAX_VALUE;
        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private static int findMax(int[] data) {
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
