package Implement.Greedy.Knapsack;

public class Knapsack {

    protected static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int handle(int W, int weight[], int value[], int n) {
        if (n == 0 || W == 0)
            return 0;

        // Membuat tabel knapsack
        int[][] K = new int[n + 1][W + 1];

        // Mengisi tabel knapsack secara bottom-up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weight[i - 1] <= w)
                    K[i][w] = max(value[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // Menampilkan judul kolom (kapasitas sisa knapsack)
        System.out.print("Iterasi\t");
        for (int w = 0; w <= W; w++) {
            System.out.print("W=" + w + "\t");
        }
        System.out.println();

        // Menampilkan tabel knapsack dengan judul baris (nomor iterasi)
        for (int i = 0; i <= n; i++) {
            System.out.print("i=" + i + "\t");
            for (int w = 0; w <= W; w++) {
                System.out.print(K[i][w] + "\t");
            }
            System.out.println();
        }

        return K[n][W];
    }
}
