package No48_50_Arrays_And_List;

import java.util.Arrays;

public class Q3_88_MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //without using extra space
        // start from the ends of both the arrays
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) { // run until one of the pointer reached to the end
            // compare both elements enter the larger one first and decrease the pointer
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // fill the remaining elements if any
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        //Merge two sorted arrays in place (in nums1);
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));;
    }
}
