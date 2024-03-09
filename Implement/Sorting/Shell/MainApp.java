package Implement.Sorting.Shell;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Tyrion", "Arya", "Daenerys", "Sansa", "Cersei" };
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new ShellSort<>(integers).sort();
        new ShellSort<>(strings).sortRecursively();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

}
