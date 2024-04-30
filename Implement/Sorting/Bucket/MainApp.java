package Implement.Sorting.Bucket;

import Implement.Sorting.RandomData.FromResult;
import Implement.Sorting.RandomData.ShowFinalResult;

public class MainApp {
    public static void main(String[] madeWithLove_byOskhar) {
        int[] data = FromResult.handle();

        long startTime = System.currentTimeMillis();
        Bucket.handle(data);
        long endTime = System.currentTimeMillis();

        ShowFinalResult.handle(data);
        System.out.println("Waktu eksekusi Bucket sort: " + (endTime - startTime) + " milidetik");
    }

}
