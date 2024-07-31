package Implement.Greedy.Knapsack;

public class MainApp {

    // Driver code
    public static void main(String args[]) {
        System.out.println("\n===== TABLE KNAPSACK =====\n");

        // int profit[] = { 75000, 70000, 80000, 30000, 30000, 50000, 40000 };
        // int weight[] = { 6, 10, 12, 14, 15, 20, 30 };
        // int W = 77;
        // int n = profit.length;
        // int profit[] = new int[] { 32, 59, 30, 17, 81, 16, 39, 25 };
        // int weight[] = new int[] { 5, 2, 3, 2, 6, 2, 4, 3 };
        // int W = 9;
        // int n = profit.length;
        // int profit[] = new int[] { 480, 360, 750, 900, 250 };
        // int weight[] = new int[] { 80, 120, 100, 125, 50 };
        // int W = 410;
        // int n = profit.length;
        int profit[] = { 80000, 75000, 60000, 50000, 40000, 30000, 30000 };
        int weight[] = { 12, 6, 10, 20, 30, 14, 15 };
        int W = 92;
        int n = profit.length;

        System.out.println("Batas maksimum weight: " + W);
        System.err.print("profit: [ ");

        for (int i = 0; i < profit.length; i++) {
            System.out.print(profit[i]+" ");
        }

        System.err.println("]");

        System.err.print("weight: [ ");

        for (int i = 0; i < weight.length; i++) {
            System.out.print(weight[i]+" ");
        }

        System.err.println("]\n");

        int result = Knapsack.handle(W, weight, profit, n);

        System.out.println("\nBerat maksimum = " + result);
    }
}
