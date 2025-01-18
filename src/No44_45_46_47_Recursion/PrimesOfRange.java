package No44_45_46_47_Recursion;

import java.util.Arrays;

public class PrimesOfRange {
    public static boolean isPrime(int n) {
        if (n == 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;
        for (int i = 3; i <= n / i; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean[] PrimeRange(int n) {
        boolean[] arr = new boolean[n + 1];
        if (n <= 1) return arr;
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arr[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    if(j % i == 0) arr[j] = false;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        boolean[] arr = PrimeRange(40);
        for(int i = 0; i < arr.length; i++){
            if(arr[i]) System.out.println(i);
        }
    }
}
