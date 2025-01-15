package No44_45_46_47_Recursion;

public class Fibonacci {
    public static void fibo(int n, int first, int second) {
        if (n == 0) return;
        System.out.print(first + " ");
        int third = first + second;
        fibo(--n, second, third);
    }

    public static void main(String[] args) {
        int n = 10;
        fibo(n, 0, 1 );
//        int first = 0, second = 1;
//        for (int i = 1; i <= n ; i++) {
//            System.out.print(first + " ");
//            int third = first + second;
//            first = second;
//            second = third;
//        }
    }
}
