package Implement.DP.LCS;

public class MainApp {
    public static int find(char[] arr, char[] brr, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (arr[i - 1] == brr[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        // Langsung memasukkan data untuk diproses
        String str = "12345678559";
        String str1 = "56785";

        char[] arr = str.toCharArray();
        char[] brr = str1.toCharArray();
        int n = str.length();
        int m = str1.length();

        System.out.println("First string: " + str);
        System.out.println("Second string: " + str1);
        System.out.println("Length of the maximum common subsequence: " + find(arr, brr, n, m));
    }
}
