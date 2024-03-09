package Implement.Sorting.Heap;

import Implement.Sorting.RandomData.FromResult;
import Implement.Sorting.RandomData.ShowResult;

public class MainApp {
    public static void main(String[] madeWithLove_byOskhar) {
        int[] data = FromResult.handle();

        long startTime = System.currentTimeMillis();
        Heap.handle(data);
        long endTime = System.currentTimeMillis();

        ShowResult.handle(data);
        System.out.println("Waktu eksekusi: " + (endTime - startTime) + " milidetik");
    }
}
