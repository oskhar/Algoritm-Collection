package Implement.Sorting.RandomData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FromResult {
    public static int[] handle() {
        int size = RandomInteger.size;

        /*
         * Declaration variable
         */
        int[] randomArray = new int[size];

        /**
         * Bussines Logic
         */
        try {
            File file = new File("result.txt");
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < size; i++) {
                int tmpNumber = Integer.parseInt(scanner.nextLine());
                randomArray[i] = tmpNumber;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file: result.txt");
            e.printStackTrace();
        }

        return randomArray;
    }
}
