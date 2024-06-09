package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PermutationStringBasicMethod {
    public static void printp(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            String rem = left + right;

            printp(rem, ans + ch);
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void powerSet(String s, int index, String temp, List<String> ans){
        if(index == s.length()){
            ans.add(temp);
            return;
        }
        char ch = s.charAt(index);
        powerSet(s, index + 1, temp, ans);
        powerSet(s, index + 1, temp + ch, ans);
    }
    public static void helper(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for(int j: nums){
                temp.add(j);
            }
            ans.add(temp);
            return;
        }
//        swap(nums, index, index);
//        helper(nums, index + 1, ans);
//        swap(nums, index, index + 1);
//
//        helper(nums, index + 1, ans);
//        swap(nums, index, index + 1);
        for (int i = index; i < nums.length - 1; i++) {
            swap(nums, index, i);
            helper(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printp(str, "");
//        List<List<Integer>> ans = new ArrayList<>();
    }
}
