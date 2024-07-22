package Implement.Sorting.RandomData;

public class RemoveDuplicates {
    
    public static int[] handle(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    array[j] = -1; // Tandai sebagai duplikat
                }
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != -1) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != -1) {
                result[index++] = array[i];
            }
        }

        return result;
    }
}
