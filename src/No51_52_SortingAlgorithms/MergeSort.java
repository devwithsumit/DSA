package No51_52_SortingAlgorithms;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;

public class MergeSort {
    public static void display(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void divide(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;

        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        display(arr, start, end);
//        System.out.println("  |  start: " + start + " mid: " + mid + " end: " + end);
//        System.out.println();
        merge(arr, start, mid, end);
//        System.out.println();
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int x = mid - start + 1;
        int y = end - mid;
        int[] arr = new int[x];
        int[] brr = new int[y];
        System.arraycopy(nums, start, arr, 0, x);
        System.arraycopy(nums, mid + 1, brr, 0, y);
        int i = 0, j = 0, k = start;
        while (i < x && j < y) {
            if (arr[i] < brr[j]) {
                nums[k++] = arr[i++];
            } else {
                nums[k++] = brr[j++];
            }
        }
        while (i < x) {
            nums[k++] = arr[i++];
        }
        while (j < y) {
            nums[k++] = brr[j++];
        }
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 9, 0, 3, 4, 8, 6};
        divide(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }
}
