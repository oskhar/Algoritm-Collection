package Implement.Sorting.RandomData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FromResult {
    public static int[] handle() {
        /*
         * Declaration variable
         */
        int[] randomArray = new int[RandomInteger.size];

        /**
         * Bussines Logic
         */
        try {
            File file = new File("result.txt");
            Scanner scanner = new Scanner(file);
            String[] data = scanner.nextLine().split(" ");
            scanner.close();

            for (int i = 0; i < RandomInteger.size; i++) {
                int tmpNumber = Integer.parseInt(data[i]);
                randomArray[i] = tmpNumber;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file: result.txt");
            e.printStackTrace();
        }

        return randomArray;
    }
}
