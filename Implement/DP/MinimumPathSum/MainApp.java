package Implement.DP.MinimumPathSum;

public class MainApp {

    public static int minCostPathDP(int[][] arr, int row, int column) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] storage = new int[m][n];
        storage[m - 1][n - 1] = arr[m - 1][n - 1];
        // Last Row
        for (int j = n - 2; j >= 0; j--) {
            storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j];
        }
        // Last Column
        for (int i = m - 2; i >= 0; i--) {
            storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                storage[i][j] = arr[i][j]
                        + Math.min(storage[i][j + 1], Math.min(
                                storage[i + 1][j + 1], storage[i + 1][j]));
            }
        }
        return storage[0][0];
    }

    public static void main(String[] args) {
        // Langsung memasukkan data untuk diproses
        int[][] arr = {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}
        };
        int row = 2;  // Baris tujuan
        int column = 2;  // Kolom tujuan

        System.out.println("Minimum Path Sum: " + minCostPathDP(arr, row, column));
    }
}
