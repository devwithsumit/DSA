package No48_50_Arrays_And_List;

public class Q7_724_pivotIndex {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            leftSums[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(leftSums[i] == sum) return i;
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
