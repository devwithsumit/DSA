package No_64_68_Recursion_Revisit;

public class Q1_TowerOfHanoi {
//    static int count = 0;
    public static void solvePuzzle(int n, int S, int H, int D) {
//        count++;
        if (n == 1) {
            System.out.println(S + " -> " + D);
            return;
        }
        solvePuzzle(n - 1, S, D, H);

        System.out.println(S + " -> " + D);

        solvePuzzle(n - 1, H, S, D);
    }

    public static void main(String[] args) {
        int n = 3;
        int t1 = 1, t2 = 2, t3 = 3;
        solvePuzzle(n, t1, t2, t3);
//        System.out.println(count);
    }
}
