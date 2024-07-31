package Implement.Greedy.Coin;

import java.util.Vector;

public class MainApp {
    static int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    static int n = deno.length;

    static void findMin(int V) {
        // Inisialisasi hasil
        Vector<Integer> ans = new Vector<>();

        // Menjelajahi semua denominasi dari yang terbesar hingga terkecil
        for (int i = n - 1; i >= 0; i--) {
            // Menemukan denominasi yang dapat digunakan
            while (V >= deno[i]) {
                V -= deno[i];  // Mengurangi nilai V dengan denominasi
                ans.add(deno[i]);  // Menambahkan denominasi ke hasil
                // Menampilkan proses pengurangan dan nilai saat ini dari V
                System.out.println("Menggunakan koin: " + deno[i] + ", Nilai yang tersisa: " + V);
            }
        }

        // Mencetak hasil
        System.out.print("Minimal koin yang dibutuhkan: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.elementAt(i));
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int n = 93;
        System.out.print("Menghitung minimal koin untuk nilai " + n + ": \n");
        findMin(n);
    }
}
