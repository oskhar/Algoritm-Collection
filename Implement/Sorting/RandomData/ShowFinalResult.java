package Implement.Sorting.RandomData;

public class ShowFinalResult {
    public static void handle(int[] randomArray) {
        for (int number : randomArray) {
            System.out.print(number + " ");
        }

        showSizeOfData();
    }

    public static void showSizeOfData() {
        System.out.println("\n\nJumlah data yang disorting: " + RandomInteger.size);
    }
}
