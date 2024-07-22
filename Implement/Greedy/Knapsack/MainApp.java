package Implement.Greedy.Knapsack;

public class MainApp {

    // Driver code
    public static void main(String args[]) {
        System.out.println("\n===== TABLE KNAPSACK =====\n");

        int profit[] = new int[] { 32, 59, 30, 17, 81, 16, 39, 25 };
        int weight[] = new int[] { 5, 2, 3, 2, 6, 2, 4, 3 };
        int W = 9;
        int n = profit.length;

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
