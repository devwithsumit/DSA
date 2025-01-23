package No48_50_Arrays_And_List;

import java.util.Arrays;

public class Q4_1089_DuplicatesZeros {
    //write method for checking and inserting if 'j' is in bounds
    public static void write(int[] arr, int j, int elem) {
        if (j < arr.length) {
            arr[j] = elem;
        }
    }

    public static void duplicateZeros(int[] arr) {

        // without extra space
        int n = arr.length;
        int zeroFreq = 0;

        // Count the number of zeros
        for (int j : arr) {
            if (j == 0)
                zeroFreq++;
        }
        int i = n - 1; // Pointer to process the original array
        int j = n + zeroFreq - 1; // Pointer to place the elements in the expanded array

        while (i >= 0 && j >= 0) {
            if (arr[i] == 0) {
                //extra copy of 0 to get a duplicate
                write(arr, j--, arr[i]);
            }
            //simple copy each element zero and non - zeros
            write(arr, j--, arr[i--]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
