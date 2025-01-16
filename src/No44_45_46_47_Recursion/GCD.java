package No44_45_46_47_Recursion;

public class GCD {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public static int lcm(int a, int b){
        return (a * b)/gcd(a,b);
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        System.out.println(lcm(10,24));
    }
}
