package No55_56_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q6_CountDistinctInWindow {
    public static List<Integer> countDistincts(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ans.add(map.size());
        int i = 1, j = k;
        while (j < nums.length) {
            //reduce the prev element from the map
            int prev = nums[i - 1];
            //if the freq becomes 0 completely remove it
            if(map.get(prev) == 1) map.remove(prev);
            else map.put(prev, map.get(prev) - 1);

            // add new element at the 'j' pointer or increase its freq if already exists
            int next = nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0 ) + 1);

            // add the final size the list
            ans.add(map.size());
            // slide the window forward
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        List<Integer> list = countDistincts(arr, 4);
        System.out.println(list);// output - 3 4 4 3
    }
}
