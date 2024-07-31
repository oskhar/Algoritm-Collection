package Implement.Sorting.RandomData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomLarge {

    private static final long TOTAL_NUMBERS = 1_000_000_000_000L;
    private static final int NUMBERS_PER_LINE = 10_000_000;
    private static final long MAX_LIMIT = 1_000_000_000_000L;

    public static void main(String[] args) {
        try {
            generateRandomNumbers("random_numbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateRandomNumbers(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        Random random = new Random();
        
        long totalGenerated = 0;
        StringBuilder lineBuilder = new StringBuilder();
        
        while (totalGenerated < TOTAL_NUMBERS) {
            int numbersInLine = 0;
            while (numbersInLine < NUMBERS_PER_LINE && totalGenerated < TOTAL_NUMBERS) {
                long randomNumber = 1 + (long) (random.nextDouble() * (MAX_LIMIT - 1));
                lineBuilder.append(String.format("%013d", randomNumber)).append(" ");
                numbersInLine++;
                totalGenerated++;
            }
            writer.write(lineBuilder.toString().trim());
            writer.newLine();
            lineBuilder.setLength(0); // Clear the StringBuilder
        }
        
        writer.close();
    }
}
