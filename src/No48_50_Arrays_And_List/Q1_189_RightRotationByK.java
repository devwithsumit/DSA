package No48_50_Arrays_And_List;

public class Q1_189_RightRotationByK {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, k - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5}, 2);
    }
}
