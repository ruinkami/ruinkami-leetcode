package com.ruinkami.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Runtime: 30 ms, faster than 93.65% of Java online submissions for 3Sum.
 * Memory Usage: 49.3 MB, less than 39.47% of Java online submissions for 3Sum.
 */
public class LC0015Threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

//        for (int i = 0; i < nums.length -1 ; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                int temp ;
//                if(nums[i]>nums[j]){
//                    temp =  nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
        Arrays.sort(nums);

        for(int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            int target = 0 - nums[k];
            while(i < j) {
                if(nums[i]+ nums[j] == target) {

                    lists.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(nums[k]);
//                    list.add(nums[i++]);
//                    list.add(nums[j--]);
//                    lists.add(list);

                    while(i < j && nums[i] == nums[i - 1]) i++;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                }
                else if(nums[i]+ nums[j] < target) i++;
                else j--;
            }
            while(k < nums.length - 2 && nums[k] == nums[k+1])
                k++;
        }

        return lists;
    }
}