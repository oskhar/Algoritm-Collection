package Sorting.Heap;

public class MainApp {

    public static void main(String[] args) {
        int[] arr = { 1, 12, 9, 5, 6, 10 };
        HeapSort hsa = new HeapSort();
        hsa.sort(arr);

        System.out.println("Sorted Array is");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
