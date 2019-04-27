package com.ruinkami.leetcode;

/**
 * Runtime: 23 ms, faster than 28.98% of Java online submissions for Two Sum.
 * Memory Usage: 38.4 MB, less than 50.90% of Java online submissions for Two Sum.
 */

public class LC0001Twosum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int aIndex = 0; aIndex < nums.length; aIndex++) {
            if (aIndex == nums.length - 1) break;
            for (int bIndex = aIndex + 1; bIndex < nums.length; bIndex++) {
                if (nums[aIndex] + nums[bIndex] == target) {
                    result[0] = aIndex;
                    result[1] = bIndex;
                    break;
                }
            }
        }

        return result;
    }

}
