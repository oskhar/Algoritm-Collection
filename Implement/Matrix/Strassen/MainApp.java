package Implement.Matrix.Strassen;

// Class Strassen matrix multiplication
public class MainApp {

    // Method 5
    // Main driver method
    public static void main(String[] args) {
        // Display message
        System.out.println(
                "Strassen Multiplication Algorithm Implementation For Matrix Multiplication :\n");

        // Create an object of Strassen class
        // in the main function
        Strassen s = new Strassen();

        // Size of matrix
        // Considering size as 4 in order to illustrate
        int N = 4;

        // Matrix A
        // Custom input to matrix
        int[][] A = { { 1, 2, 3, 4 },
                { 4, 3, 0, 1 },
                { 5, 6, 1, 1 },
                { 0, 2, 5, 6 } };

        // Matrix B
        // Custom input to matrix
        int[][] B = { { 1, 0, 5, 1, 3 },
                { 1, 2, 0, 2, 2 },
                { 0, 3, 2, 3, 3 },
                { 1, 2, 1, 2, 3 } };

        // Matrix C computations

        // Matrix C calling method to get Result
        int[][] C = s.multiply(A, B);

        // Display message
        System.out.println("\nProduct of matrices A and B : ");

        // Iterating over elements of 2D matrix
        // using nested for loops

        // Outer loop for rows
        for (int i = 0; i < N; i++) {
            // Inner loop for columns
            for (int j = 0; j < N; j++)

                // Printing elements of resultant matrix
                // with whitespaces in between
                System.out.print(C[i][j] + " ");

            // New line once the all elements
            // are printed for specific row
            System.out.println();
        }
    }
}
