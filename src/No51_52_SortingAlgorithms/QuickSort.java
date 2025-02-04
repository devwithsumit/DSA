package No51_52_SortingAlgorithms;

import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.StreamSupport;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int partIdx = partition(arr,start, end);
            quickSort(arr, start, partIdx - 1);
            quickSort(arr, partIdx + 1, end);
        }
    }
    public static int partition(int[] arr, int start, int end){
//        int pivot = arr[start];
//        int i = start - 1;
//        for (int j = start; j < end; j++) {
//            if (arr[j] < pivot){
//                i++;
//                int temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//            }
//        }
//        i++;
//        int temp = arr[i];
//        arr[i] = arr[end];
//        arr[end] = temp;
//        return i;
        int pivot = arr[start];
        int i = start, j = end;
        while(i < j){
            while(arr[i] < pivot && i < end){
                i++;
            }while (arr[j] > pivot && j > start){
                j--;
            }
            if(i < j ){
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;
        return j;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 9, 0, 3, 4, 8, 6};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
