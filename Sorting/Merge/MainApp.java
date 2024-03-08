package Sorting.Merge;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Void Elf", "Vulpera", "Human", "Troll", "Undead" };
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new MergeSortSub<>(integers).sort();
        new MergeSortTemp<>(strings).sort();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

}
