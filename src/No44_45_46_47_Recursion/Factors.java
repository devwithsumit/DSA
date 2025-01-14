package No44_45_46_47_Recursion;

public class Factors {

    public static void main(String[] args) {
        int n = 11;
        for (int i = 1; i <= n / i; i++) { // n / i -> till the sqrt of n
            if(n % i == 0) {
                System.out.println(i);
                if(n / i != i){ // to remove redundancy
                    System.out.println(n / i);
                }
            }
        }
    }
}
