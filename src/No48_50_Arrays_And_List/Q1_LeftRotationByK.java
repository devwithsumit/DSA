package No48_50_Arrays_And_List;

import java.util.Arrays;

public class Q1_LeftRotationByK {
    public static void leftRotation(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, k, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        leftRotation(new int[]{1, 2, 3, 4, 5}, 2);
    }
}
