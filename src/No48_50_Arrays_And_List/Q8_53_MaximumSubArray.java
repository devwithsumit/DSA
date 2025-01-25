package No48_50_Arrays_And_List;

import java.util.Arrays;
import java.util.Collections;
import java.util.jar.JarEntry;

public class Q8_53_MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 3, -2, 6, -9, 0};
        int max = 0;
        int sum = 0;
        int ansi = -1;
        int ansj = -1;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) start = i;
            sum += arr[i];
            if(max < sum){
                max = sum;
                ansi = start;
                ansj = i;
            };
            if (sum < 0) sum = 0;
        }
        System.out.println(max);
        System.out.println(ansi);
        System.out.println(ansj);
        int[] brr = Arrays.copyOfRange(arr, ansi, ansj + 1);
        System.out.println(Arrays.toString(brr));
    }
}
