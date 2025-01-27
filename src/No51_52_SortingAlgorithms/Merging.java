package No51_52_SortingAlgorithms;

import java.util.Arrays;

public class Merging {
    public static void merge(int[] nums, int s, int m, int e){
        int x = m - s + 1;
        int y = e - m;
        int[] arr = new int[x];
        int[] brr = new int[y];
        System.arraycopy(nums, 0, arr, 0, x);
        System.arraycopy(nums,m + 1, brr,0,y);
        int i = 0, j = 0, k = 0;
        while(i < x && j < y){
            if(arr[i] < brr[j]){
                nums[k++] = arr[i++];
            }else{
                nums[k++] = brr[j++];
            }
        }
        while (i < x){
            nums[k++] = arr[i++];
        }
        while (j < y){
            nums[k++] = arr[j++];
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        merge(new int[]{1,4,7,9,2,3,5,8,9},0,3,8);
    }
}
