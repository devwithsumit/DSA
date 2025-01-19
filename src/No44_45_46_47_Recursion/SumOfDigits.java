package No44_45_46_47_Recursion;

public class SumOfDigits {
    public static int sumOfDigit(int n) {
        if (n <= 0) return n;
        int sum =0;
        sum += n % 10;
        n /= 10;
        return sum + sumOfDigit(n);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigit(32145));;
    }
}
