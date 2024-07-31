package Implement.Sorting.RandomData;

import Implement.Sorting.Heap.SuperHeap;
import java.util.Random;

public class Large {
    public static void main(String[] args) {
        /**
         * Mengatur batas masimal setiap innerArray
         * 
         */
        int innerArraySize = 10_000_000;
        
        /**
         * Mengatur jumlah data yang dikeluarkan
         * 
         * Contoh data yang bu hanif minta
         * 1_000_000_000_000L
         * 
         */
        long totalNumbers = 1_000_000_000_000L;
        int outerArraySize = (int) (totalNumbers / innerArraySize + (totalNumbers % innerArraySize == 0 ? 0 : 1));

        Random random = new Random();
        
        for (int i = 0; i < outerArraySize; i++) {
            /**
             * Mengenerate angka random
             * 
             */
            int currentInnerArraySize = (i == outerArraySize - 1) ? (int) (totalNumbers % innerArraySize) : innerArraySize;
            if (currentInnerArraySize == 0) {
                currentInnerArraySize = innerArraySize;
            }

            long[] innerArray = new long[currentInnerArraySize];
            for (int j = 0; j < currentInnerArraySize; j++) {
                innerArray[j] = (long) i * innerArraySize + j + 1;
            }
            
            for (int j = currentInnerArraySize - 1; j > 0; j--) {
                int index = random.nextInt(j + 1);
                long temp = innerArray[index];
                innerArray[index] = innerArray[j];
                innerArray[j] = temp;
            }

            /**
             * Cetak semua data random
             * 
             */
            System.out.println("Before sorting:");
            for (long number : innerArray) {
                System.out.printf("%013d ", number);
            }
            System.out.println();

            /**
             * Melakukan sorting pada data
             * 
             */
            SuperHeap.sort(innerArray);

            /**
             * Keluarkan hasil angka yang sudah tersorting
             * 
             */
            System.out.println("After sorting:");
            for (long number : innerArray) {
                System.out.printf("%013d ", number);
            }
            System.out.println();
        }
    }
}
