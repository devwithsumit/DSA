package No44_45_46_47_Recursion;

public class LCM {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
//        for (int i = Math.max(a, b); i <= a * b; i += Math.max(a, b)) {
//            if (i % a == 0 && i % b == 0) {
//                return i;
//            }
//        }
        // formula lcm == a * b/ gcd(a,b);
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println("LCM: " + lcm(24, 18));
        System.out.println("GCD: " + GCD.gcd(24, 18));
    }
}
