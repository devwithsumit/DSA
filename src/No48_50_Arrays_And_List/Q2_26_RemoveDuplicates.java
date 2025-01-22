package No48_50_Arrays_And_List;

import java.util.Arrays;

public class Q2_26_RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1;  j < arr.length ; j++) {
            if(arr[i] != arr[j]){
                arr[++i] = arr[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        System.out.println(Arrays.toString(arr));

        int index = removeDuplicates(arr);

        int[] brr = new int[index + 1];
        System.arraycopy(arr, 0, brr, 0, index + 1);

        System.out.println(Arrays.toString(brr));
    }
}
