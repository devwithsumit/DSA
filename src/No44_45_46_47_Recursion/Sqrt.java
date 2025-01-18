package No44_45_46_47_Recursion;

public class Sqrt {
    public static int sqrtx(int x) {
        // sqrt by binary search;
        int ans = 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = (start + end) / 2;
            if ((long) mid * mid <= x) {
                start = mid + 1;
                ans = mid;
            } else end = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrtx(10));
    }
}
