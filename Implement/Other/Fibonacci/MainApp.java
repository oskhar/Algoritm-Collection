package Implement.Other.Fibonacci;

public class MainApp {
    static void fib(int n) {
        int a = 0, b = 1, c;
        if (n == 0) {
            System.out.print(a);
            return;
        }
        System.out.print(a + " " + b);
        for (int i = 2; i <= n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int n = 9;
        fib(n);
    }
}
