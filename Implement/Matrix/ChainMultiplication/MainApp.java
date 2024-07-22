package Implement.Matrix.ChainMultiplication;

import java.util.*;

public class MainApp {
    public static int[] brr = new int[100];
    public static int g = 0;
    public static int[][] breakmatrix = new int[100][100];

    public static int[][] matrix(int[] arr, int n) {
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(mat[i], 0);
            Arrays.fill(breakmatrix[i], 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                int l = j + i;
                mat[j][l] = Integer.MAX_VALUE;
                for (int k = j; k < l; k++) {
                    int temp = mat[j][k] + mat[k + 1][l] + arr[j - 1] * arr[k] * arr[l];
                    if (temp < mat[j][l]) {
                        mat[j][l] = temp;
                        breakmatrix[j][l] = k;
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(breakmatrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The optimal solution is : " + mat[1][n]);
        return breakmatrix;
    }

    public static void print(int i, int j) {
        if (Math.abs(j - i) < 2)
            return;
        brr[g] = breakmatrix[i][j];
        g++;
        print(i, breakmatrix[i][j]);
        print(breakmatrix[i][j] + 1, j);
    }

    public static void printmatrix(int[] a) {
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            String t = "(" + a[i] + "X" + a[i + 1] + ")";
            s.add(t);
        }
        for (int j = 0; j < g; j++) {
            s.add(brr[j], "|");
        }
        for (String value : s) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        // Langsung memasukkan data untuk diproses
        int n = 4; // Jumlah matriks - 1
        int[] a = {10, 20, 30, 40, 30}; // Dimensi matriks

        int[][] kmat = matrix(a, n);
        print(1, n);
        System.out.println("The optimal way for multiplication is: ");
        printmatrix(a);
    }
}
