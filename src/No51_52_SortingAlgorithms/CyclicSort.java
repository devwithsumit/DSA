package No51_52_SortingAlgorithms;

import java.util.Arrays;

public class CyclicSort {
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int current = arr[i];
            while (current != i + 1){
                int temp = arr[i];
                arr[i] = arr[current - 1];
                arr[current - 1] = temp;
                current = arr[i];
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6, 7, 3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
