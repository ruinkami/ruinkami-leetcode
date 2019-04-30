package com.ruinkami.leetcode;

import java.util.Arrays;

/**
 * Runtime: 6 ms, faster than 81.72% of Java online submissions for 3Sum Closest.
 * Memory Usage: 37.9 MB, less than 50.96% of Java online submissions for 3Sum Closest.
 */
public class LC0016Threesumclosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        boolean closestInit = false;
        int closest = Integer.MIN_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            int subTarget = target - nums[k];
            while (i < j) {
                if (nums[i] + nums[j] == subTarget) {
                    return target;
//                    return nums[k] + nums[i++] + nums[j--];
//                    while(i < j && nums[i] == nums[i - 1]) i++;
//                    while(i < j && nums[j] == nums[j + 1]) j--;
                } else if (nums[i] + nums[j] < subTarget) {
                    int t = nums[i] + nums[j] + nums[k];
                    if (!closestInit) {
                        closest = t;
                        closestInit = true;
                    } else {
                        closest = Math.abs(target - closest) > Math.abs(target - t) ? t : closest;
                    }
                    i++;
                } else {
                    int t = nums[i] + nums[j] + nums[k];
                    if (!closestInit) {
                        closest = t;
                        closestInit = true;
                    } else {
                        closest = Math.abs(target - closest) > Math.abs(target - t) ? t : closest;
                    }
                    j--;

                }
            }
            if (j + 1 > nums.length - 1) {
                int t = nums[i - 1] + nums[j] + nums[k];
                closest = Math.abs(target - closest) > Math.abs(target - t) ? t : closest;
            } else if (i - 1 < k + 1) {
                int t = nums[i] + nums[j + 1] + nums[k];
                closest = Math.abs(target - closest) > Math.abs(target - t) ? t : closest;
            } else {
                int t1 = nums[i] + nums[j + 1] + nums[k];
                int t2 = nums[i - 1] + nums[j] + nums[k];
                if (Math.abs(target - t1) <= Math.abs(target - t2)) {
                    closest = Math.abs(target - closest) > Math.abs(target - t1) ? t1 : closest;
                } else {
                    closest = Math.abs(target - closest) > Math.abs(target - t2) ? t2 : closest;
                }
            }
            while (k < nums.length - 2 && nums[k] == nums[k + 1])
                k++;
        }

        return closest;
    }
}