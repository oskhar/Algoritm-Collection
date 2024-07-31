package Implement.Sorting.Large;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static final int NUMBERS_PER_LINE = 10_000_000;

    public static void main(String[] args) {
        String inputFile = "random_numbers.txt";
        String outputFile = "sorted_numbers.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
             
            String line;
            List<Long> numbers = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    numbers.add(Long.parseLong(token));
                }
                long[] array = numbers.stream().mapToLong(Long::longValue).toArray();
                MergeHeapSort.sort(array);
                
                for (long num : array) {
                    writer.write(String.format("%013d", num) + " ");
                }
                writer.newLine();
                numbers.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
